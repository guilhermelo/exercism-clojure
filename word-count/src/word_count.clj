(ns word-count
  (:require [clojure.string :as s]))

(defn mapa-palavras [palavras]
  (reduce (fn [mapa palavra]
            (if (contains? mapa palavra)
              (update mapa palavra inc)
              (assoc mapa palavra 1))) {} palavras))

(defn word-count [s] ;; <- arglist goes here
  (-> (map #(s/lower-case %) (re-seq #"\w+" s))
      mapa-palavras))
