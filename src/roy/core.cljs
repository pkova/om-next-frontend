(ns roy.core
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(defui App
  Object
  (render [this]
          (dom/div nil "Hello, World!")))

(def app (om/factory App))

(js/ReactDOM.render (app) (gdom/getElement "app"))
