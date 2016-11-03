(ns roy.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [roy.styles :as styles]))

(def app-state
  (atom
   {:rounds [{:round 1
              :img ""
              :category "PEPPERONI PIZZA"
              :first-contestant "Jersey"
              :second-contestant "Slice House"
              :selected true}

             {:round 2
              :img ""
              :category "MEATBALL SUBS"
              :first-contestant "Jersey"
              :second-contestant "Merrigan"}

             {:round 3
              :img ""
              :category "CHEESEBURGERS"
              :first-contestant "Popsons"
              :second-contestant "In-N-Out"}]}))


(defmulti read (fn [env key params] key))

(defmethod read :default
  [{:keys [state] :as env} key params]
  (let [st @state]
    (if-let [[_ value] (find st key)]
      {:value value}
      {:value :not-found})))

(defn getfeedback-eats-h2 []
  (dom/h2 #js {:style styles/getfeedback-eats-h2}
          "GETFEEDBACK EATS"))

(defn this-vs-that-h1 []
  (dom/h1 #js {:style styles/this-vs-that-h1}
          "#this-vs-that"))

(defn logo []
  (dom/img #js {:src "assets/gf-logo.png"
                :style styles/logo}))

(defn video []
  (dom/video #js {:src "./assets/37951023.mp4"
                  :loop true
                  :autoPlay true
                  :muted true
                  :style styles/video}))

(defn video-cover []
  (dom/div #js {:style styles/video-cover}))

(defn nav []
  (dom/header #js {:style styles/nav}
              (video-cover)
              (video)
              (logo)
              (this-vs-that-h1)
              (getfeedback-eats-h2)))

(defn get-instafeed []
  (.run (js/Instafeed. #js {:get "user"
                            :userId "297334"
                            :clientId "9c2041d32b2b459a8341f495b28877ac"
                            :accessToken "297334.9c2041d.700c595cb96b4873b0d547c0ca70f022"
                            :template "<a href=\"{{link}}\"><img src=\"{{image}}\" /></a>"})))

(defui Instafeed
  Object
  (componentDidMount [this]
                     (get-instafeed))
  (render [this]
          (dom/div #js {:style styles/body}
                   (dom/h1 nil (:h1 (om/props this)))
                   (dom/h2 nil (:h2 (om/props this)))
                   (dom/div #js {:id "instafeed"
                                 :style styles/instafeed}))))

(def instafeed (om/factory Instafeed))

(defui Winner
  Object
  (render [this]
          (dom/div #js {:style #js {:textAlign "center"}}
                   (dom/h1 nil "And the winner is...")
                   (dom/div #js {:style #js {:display "inline-block"}}
                            (dom/div nil "ROUND 1")
                            (dom/div nil "ROUND 2")
                            (dom/div nil "ROUND 3")))))

(def winner (om/factory Winner {:keyfn :h1}))

(defui App
  Object
  (render [this]
          (dom/div nil
                   (nav)
                   (instafeed {:h1 "Sometimes we work. Always we eat" :h2 "What shall we feast on this week? Inspiration from the @eater_sf instagram:"})
                   (winner))))

(def reconciler
  (om/reconciler
   {:state app-state
    :parser (om/parser {:read read})}))

(om/add-root! reconciler App (gdom/getElement "app"))
