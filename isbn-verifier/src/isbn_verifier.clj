(ns isbn-verifier)

(defn calculate-isbn [xs total multiplier]
  (if (empty? xs)
    (mod total 11)
    (let [digit (first xs)
          is-letter (= "X" digit)]
      (if is-letter
        (calculate-isbn (rest xs) (+ total (* multiplier 10)) (dec multiplier))
        (let [number (Integer/parseInt digit)]
          (calculate-isbn (rest xs) (+ total (* multiplier number)) (dec multiplier)))))))

(defn x-not-verify-digit [xs] 
  (and (some #(= "X" %) xs) (not= "X"(last xs))))

(defn isbn? [isbn]
  (let [digits (re-seq #"[0-9]|[x]|[X]" isbn)]
    (if (or (not= (count digits) 10) (x-not-verify-digit digits))
      false
      (= (calculate-isbn digits 0 10) 0))))