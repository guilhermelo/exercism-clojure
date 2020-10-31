(ns anagram
  (:require [clojure.string :as s]))

(defn anagram-and-not-equal? [word-for-analize original-word]
  (and (not= (s/lower-case word-for-analize) (s/lower-case original-word))
   (= (sort (s/lower-case word-for-analize)) (sort (s/lower-case original-word)))))

(defn anagrams-for [word prospect-list]
  (reduce (fn [anagrams current-word]
            (if (anagram-and-not-equal? current-word word)
              (conj anagrams current-word)
              anagrams)) [] prospect-list))
