(ns reverse-string)

(defn reverse-string [s]
  (if (= s "")
    s
    (->> (reduce conj '() (clojure.string/split s #""))
        (reduce str ""))))
