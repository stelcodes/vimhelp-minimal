(ns vimhelp.core
  (:require
   [clojure.java.io :as io]
   [vimhelp.html :as h]
   [vimhelp.parser :as p]))

(defn file->hiccup [path]
  (with-open [r (io/reader path)]
    (->> r
         p/parse
         (map #(h/render % {})))))
