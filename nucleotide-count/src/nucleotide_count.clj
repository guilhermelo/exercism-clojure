(ns nucleotide-count)

(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (empty? strand)
    0
    (let [amount (->> (re-seq #"\w" strand)
                      (filter #(= (.charAt % 0) nucleotide))
                      (count))]
      (if (> amount 0)
        amount
        (throw (Exception. (str "There's no " nucleotide " in this strand")))))))


(defn nucleotide-counts [strand]
  (let [mapa {\A 0, \T 0, \C 0, \G 0}]
    (if (empty? strand)
      mapa
      (->> (map #(.charAt % 0) (re-seq #"\w" strand))
        (reduce (fn [m item]
                  (when (contains? m item)
                    (update m item inc))) mapa)))))