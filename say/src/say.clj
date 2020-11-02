(ns say
  (:require [clojure.string :as s]))


(def numbers
  {0 "zero"
   1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"
   100 "one hundred"
   1000 "one thousand"
   1000000 "one million"
   1000000000 "one billion"})

(defn number [num]
  (if (or (< num 0) (> num 999999999999))
    (throw (IllegalArgumentException. "Argument out of range"))
    (cond
      (numbers num) (numbers num)
      (>= num 1000000000) (str (number (quot num 1000000000)) " billion " (number (mod num 1000000000)))
      (>= num 1000000)    (str (number (quot num 1000000)) " million " (number (mod num 1000000)))
      (>= num 1000)       (str (number (quot num 1000)) " thousand " (number (mod num 1000)))
      (>= num 100)        (str (number (quot num 100)) " hundred " (number (mod num 100)))
      (> num 20)         (str (number (* 10 (quot num 10))) "-" (number (mod num 10))))))