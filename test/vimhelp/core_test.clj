(ns vimhelp.core-test
  (:require
   [clojure.test :as t]
   [vimhelp.core :as vc]))

(t/deftest help-file->hiccup
  (t/is (= (slurp "test-resources/conjure.html")
           (vc/help-file->html "test-resources/conjure.txt"))))

(comment (spit "test-resources/conjure.html"
               (vc/help-file->html "test-resources/conjure.txt")))
