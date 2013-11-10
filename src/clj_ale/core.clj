(ns clj-ale.core
  (:require [clj-temper1.core :as temper1])
  (:use [clojure.tools.logging :only (debug info error)]
        [clojure.string :only (join)]))

(defn -main [& args]
  (info (str "Loading hidapi-jni library from: " (System/getProperty "java.library.path")))
  (temper1/load-hid-natives)
  (info (str "Devices found: \n" (join "\n\n" (temper1/list-devices))))
  (info (str "Temp: " (temper1/read-temperature) "°C"))
  (System/exit 0))
