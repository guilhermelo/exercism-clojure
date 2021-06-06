(ns hamming)

(defn- number-differences [sequence-one sequence-two amount]
  (if (empty? sequence-one)
    amount
    (if (not= (first sequence-one) (first sequence-two))
      (number-differences (rest sequence-one) (rest sequence-two) (inc amount))
      (number-differences (rest sequence-one) (rest sequence-two) amount))))

(defn distance [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    nil
    (let [dna1 (re-seq #"\w" strand1)
          dna2 (re-seq #"\w" strand2)]
      (number-differences dna1 dna2 0))))
