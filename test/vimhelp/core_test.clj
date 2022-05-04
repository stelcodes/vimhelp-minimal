(ns vimhelp.core-test
  (:require
   [clojure.edn :as edn]
   [clojure.pprint :as pp]
   [clojure.test :as t]
   [vimhelp.core :as vc]))

(t/deftest help-file->ir
  (t/is (= (edn/read-string (slurp "test-resources/conjure.edn"))
           (vc/help-file->ir "test-resources/conjure.txt"))))

(comment (spit "test-resources/conjure.edn"
               (with-out-str (pp/pprint (vc/help-file->ir "test-resources/conjure.txt")))))

(t/deftest help-file->hiccup
  (t/is (= (slurp "test-resources/conjure.html")
           (vc/help-file->html "test-resources/conjure.txt"))))

(comment (spit "test-resources/conjure.html"
               (vc/help-file->html "test-resources/conjure.txt")))
