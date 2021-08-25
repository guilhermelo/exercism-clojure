(ns grains)

(defn square [square-number]
  (->> (repeat (dec square-number) 2)
       (reduce *')))

(defn total []
  (reduce +' (map square (range 1 65))))
