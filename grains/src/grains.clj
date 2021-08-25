(ns grains)

(defn square [square-number]
  (cond
    (= square-number 1) 1
    (= square-number 2) 2
    :else (loop [actual-square 3
                 previous-result 2]
            (if (= actual-square square-number)
              (*' previous-result 2)
              (recur (inc actual-square) (* previous-result 2))))))

(defn total []
  (loop [actual-square 1
         previous-result 1
         result 0]
    (if (= actual-square 64)
      result
      (recur (inc actual-square) (*' previous-result 2) (+' previous-result (*' previous-result 2))))))
