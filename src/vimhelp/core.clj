(ns vimhelp.core
  (:require
   [clojure.java.io :as io]
   [hiccup2.core :as hiccup]
   [vimhelp.html :as h]
   [vimhelp.parser :as p]))

(defn help-file->hiccup [path]
  (with-open [r (io/reader path)]
    (->> r
         p/parse
         (map #(h/render % {})))))

(defn help-file->html [path]
  (->> path
       help-file->hiccup
       hiccup/html
       (str "<DOCTYPE html>")))
