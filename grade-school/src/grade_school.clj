(ns grade-school)

(defn grade [school grade]
  (if (empty? school)
    []
    (get school grade)))

(defn add [school name grade]
  (let [names-vector (into [] (get school grade))
        names (conj names-vector name)]
    (assoc school grade names)))

(defn- map-values-ordered [[key value]]
  {key (sort value)})

(defn sorted [school]
  (into (sorted-map) (map map-values-ordered school)))


