(ns armstrong-numbers)

(defn- exp [x n]
  (reduce * (repeat n x)))

(defn armstrong? [num] 
  (let [numbers (clojure.string/split (.toString num) #"")
        amount (count numbers)
        total (reduce (fn [total x]
                        (+ total (exp (Integer/parseInt x) amount))) 0 numbers)]
    (= total num)))


