(ns roy.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(defn nav []
  (dom/header #js {:className "header"
                   :style #js{:textAlign "center"
                              :width "100%"
                              :height "50%"
                              :font-family "Open Sans"
                              :position "relative"
                              :display "flex"
                              :justifyContent "center"}}

              (dom/div #js {:style #js {:position "absolute"
                                        :width "100%"
                                        :height "100%"
                                        :margin-bottom "auto"
                                        :background "rgba(0, 0, 0, 0.6)"}})

              (dom/video #js {:src "https://12-lvl3-pdl.vimeocdn.com/01/3756/0/18782955/37951023.mp4?expires=1477449450&token=04890934395e7354e482b"
                              :autoPlay true
                              :muted true
                              :style #js {:position "absolute"
                                          :zIndex -1
                                          :width "100%"}})

              (dom/img #js {:className "logo",
                            :src "assets/gf-logo.png"
                            :style #js {:position "absolute"
                                        :transform "scale(0.5)"}})

              (dom/h1 #js {:style #js {:color "white"
                                       :position "absolute"
                                       :top "3em"}}
                      "#this-vs-that")

              (dom/h2 #js {:style #js {:color "white"
                                       :position "absolute"
                                       :top "8em"}}
                      "GETFEEDBACK EATS")))

(defui App
  Object
  (render [this]
          (nav)))

(def app (om/factory App))


(js/ReactDOM.render (app) (gdom/getElement "app"))
