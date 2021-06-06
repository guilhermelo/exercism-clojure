(ns series
  (:require [clojure.string :as s]))

(defn- digit-sequences [sequence length new-sequence]
  (let [text (s/join "" (take length sequence))]
    (if (>= (count sequence) length)
      (digit-sequences (rest sequence) length (conj new-sequence text))
      new-sequence)))

(defn slices [string length]
  (cond
    (or (empty? string) (> length (count string))) []
    (= length 0) [""]
    :else (digit-sequences string length [])))
