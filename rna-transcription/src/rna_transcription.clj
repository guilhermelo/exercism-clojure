(ns rna-transcription)

(defn parse-n [nucleotide]
  (case nucleotide 
    "G" "C"
    "C" "G"
    "T" "A"
    "A" "U"
    (throw (AssertionError. "Error"))))

(defn to-rna [dna]
  
  (->> (clojure.string/split dna #"")
       (map parse-n)
       (reduce str)))

