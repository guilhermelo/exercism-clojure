(ns collatz-conjecture)

(defn- process [n step]
  (cond
    (= n 1) step
    (even? n) (process (/ n 2) (inc step))
    :else (process (inc (* n 3)) (inc step))))

(defn collatz [num]
  (process num 0))
