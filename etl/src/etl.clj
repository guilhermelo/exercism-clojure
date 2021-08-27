(ns etl)

(defn create-list [[key value]]
  (conj (into [] (interpose key (flatten value))) key))

(defn create-map [current-list]
  (reduce (fn [m current]
            (assoc m (.toLowerCase (first current)) (last current))) {} current-list))

(defn transform [source]
  (->> (map create-list source)
       flatten
       (partition 2)
       create-map))
