(ns roy.styles)

(def logo #js {:position "absolute"
               :width "25%"
               :left "39%"
               :top "11%"})

(def getfeedback-eats-h2 #js {:color "white"
                              :fontSize "2vw"
                              :position "absolute"
                              :left "41%"
                              :top "50%"})

(def this-vs-that-h1 #js {:color "white"
                          :fontSize "6vw"
                          :fontWeight "lighter"
                          :position "absolute"
                          :left "33%"
                          :top "27%"})

(def video #js {:position "relative"
                :zIndex -1
                :width "100%"
                :display "block"})

(def video-cover #js {:position "absolute"
                      :width "100%"
                      :height "100%"
                      :margin-bottom "auto"
                      :background "rgba(0, 0, 0, 0.6)"})

(def nav #js {:textAlign "center"
              :width "100%"
              :height "50%"
              :font-family "Open Sans"
              :position "relative"
              :justifyContent "center"})

(def body #js {:textAlign "center"})
