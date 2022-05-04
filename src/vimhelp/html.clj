(ns vimhelp.html
  (:require
   [clojure.string :as str]
   [hiccup2.core :as hiccup])
  (:import
   java.net.URLEncoder))

(defn- url-encode
  [s]
  (URLEncoder/encode s "UTF-8"))

(defn replace-spaces
  [s]
  (->> s
       (partition-by #(case % \space 0 \tab 0 1))
       (map (fn [char-seq]
              (if (#{\space \tab} (first char-seq))
                (->> char-seq
                     (map #(case %
                             \space "&nbsp;"
                             \tab "&nbsp;&nbsp;&nbsp;&nbsp;"))
                     (apply str)
                     hiccup/raw)
                (apply str char-seq))))))

(defmulti render (fn [line _] (first line)))
(defmethod render :default [x _] x)

(defmethod render :text
  [[_ & elements] opts]
  (let [rendered-els (map #(cond
                            (vector? %) (render % opts)
                            (= "" (str/trim %)) [:br]
                            :else (replace-spaces %))
                          elements)]
    (when-not (zero? (count rendered-els))
      (into [:p] rendered-els))))

(defmethod render :tag
  [[_ tag-name] _]
  [:a.tag {:name (url-encode tag-name) :href (str "#" (url-encode tag-name))} tag-name])

(defmethod render :ref
  [[_ ref-name] {:keys [tags]}]
  [:a.ref {:class (when-not (contains? tags ref-name) "missing-tag")
           :href (str (get tags ref-name) "#" (url-encode ref-name))}
   ref-name])

(defmethod render :constant
  [[_ constant-name] _]
  [:span.constant constant-name])

(defmethod render :header
  [[_ header-text] _]
  [:span.header (replace-spaces header-text)])

(defmethod render :command
  [[_ command] _]
  [:code.command command])

(defmethod render :example
  [[_ example] _]
  [:code.example [:pre example]])

(defmethod render :url
  [[_ url] _]
  [:a.url {:href url} url])

(defmethod render :divider
  [[_ text] _]
  [:span.divider text])

(defmethod render :section-header
  [[_ title tag] opts]
  [:span.section-header
   (into [:span.section-title] (replace-spaces title))
   (render tag opts)])
