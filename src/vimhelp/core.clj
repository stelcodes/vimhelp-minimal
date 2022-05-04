(ns vimhelp.core
  (:require
   [clojure.java.io :as io]
   [hiccup2.core :as hiccup]
   [vimhelp.html :as h]
   [vimhelp.parser :as p]))

(defn help-file->ir [path]
  (with-open [r (io/reader path)]
    (p/parse r)))

(defn help-file->hiccup [path bad-refs]
  (->> (help-file->ir path)
       (map #(h/render % bad-refs))))

(defn help-file->html [path bad-refs]
  (->> (help-file->hiccup path bad-refs)
       hiccup/html
       (str "<DOCTYPE html>")))
