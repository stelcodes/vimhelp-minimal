(ns vimhelp.html-test
  (:require
   [clojure.test :as t]
   [hiccup2.core :as hiccup]
   [vimhelp.html :as sut]))

(t/deftest replace-spaces-test
  (t/is (= (list "hi" (hiccup/raw "&nbsp;&nbsp;") "there"
                 (hiccup/raw "&nbsp;&nbsp;&nbsp;&nbsp;") "wow"
                 (hiccup/raw "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                 "very" (hiccup/raw "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") "cool")
           (sut/replace-spaces "hi  there\twow\t\tvery \tcool"))))

(t/deftest render-tag-test
  (t/are [in out] (= out (sut/render [:tag in] {}))
    "foo",   [:a.tag {:name "foo" :href "#foo"} "foo"]
    "<foo>", [:a.tag {:name "%3Cfoo%3E" :href "#%3Cfoo%3E"} "<foo>"]))

(t/deftest render-ref-test
  (t/are [in out] (= out (sut/render [:ref in] {}))
    "foo",   [:a.ref {:href "#foo"} "foo"]
    "<foo>", [:a.ref {:href "#%3Cfoo%3E"} "<foo>"])

  (let [bad-refs #{"foo" "<foo>"}]
    (t/are [in out] (= out (sut/render [:ref in] bad-refs))
      "foo",   "foo"
      "<foo>", "<foo>")))


(t/deftest render-section-header-test
  (t/is (= [:span.section-header
            [:span.section-title "title"]
            [:a.tag {:name "foo" :href "#foo"} "foo"]]
           (sut/render [:section-header "title" [:tag "foo"]] {})))

  (t/is (= [:span.section-header
            [:span.section-title "<title>"]
            [:a.tag {:name "%3Cfoo%3E" :href "#%3Cfoo%3E"} "<foo>"]]
           (sut/render [:section-header "<title>" [:tag "<foo>"]] {}))))
