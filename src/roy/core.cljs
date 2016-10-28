(ns roy.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]
            [roy.styles :as styles]))

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

(defui Body
  Object
  (componentDidMount [this]
                     (get-instafeed))
  (render [this]
          (dom/div #js {:style styles/body}
                   (dom/h1 nil "Sometimes we work. Always we eat.")
                   (dom/h2 nil "What shall we feast on this week? Inspiration from the @eater_sf instagram:")
                   (dom/div #js {:id "instafeed"
                                 :style styles/instafeed}))))

(def body (om/factory Body))

(defui App
  Object
  (render [this]
          (dom/div nil
                   (nav)
                   (body))))

(def app (om/factory App))


(js/ReactDOM.render (app) (gdom/getElement "app"))
