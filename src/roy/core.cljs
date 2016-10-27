(ns roy.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(defn getfeedback-eats-h2 []
  (dom/h2 #js {:style #js {:color "white"
                           :fontSize "2vw"
                           :position "absolute"
                           :left "41%"
                           :top "50%"}}
          "GETFEEDBACK EATS"))

(defn this-vs-that-h1 []
  (dom/h1 #js {:style #js {:color "white"
                           :fontSize "6vw"
                           :fontWeight "lighter"
                           :position "absolute"
                           :left "33%"
                           :top "27%"}}
          "#this-vs-that"))

(defn logo []
  (dom/img #js {:src "assets/gf-logo.png"
                :style #js {:position "absolute"
                            :width "25%"
                            :left "39%"
                            :top "11%"}}))

(defn video []
  (dom/video #js {:src "./assets/37951023.mp4"
                  :autoPlay true
                  :muted true
                  :style #js {:position "relative"
                              :zIndex -1
                              :width "100%"
                              :display "block"}}))

(defn video-cover []
  (dom/div #js {:style #js {:position "absolute"
                            :width "100%"
                            :height "100%"
                            :margin-bottom "auto"
                            :background "rgba(0, 0, 0, 0.6)"}}))

(defn nav []
  (dom/header #js { :style #js {:textAlign "center"
                               :width "100%"
                               :height "50%"
                               :font-family "Open Sans"
                               :position "relative"
                               :display "inline-block"
                               :justifyContent "center"}}
              (video-cover)
              (video)
              (logo)
              (this-vs-that-h1)
              (getfeedback-eats-h2)))

(defui App
  Object
  (render [this]
          (nav)))

(def app (om/factory App))


(js/ReactDOM.render (app) (gdom/getElement "app"))
