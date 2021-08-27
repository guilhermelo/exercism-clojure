(ns flatten-array)

(defn flatten [arr]
  (filter #(not (nil? %)) (clojure.core/flatten arr)))
