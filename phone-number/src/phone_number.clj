(ns phone-number
  (:require [clojure.string :as s]))

(def invalid "0000000000")

(defn- is-icc-code-valid? [xs]
  (= (first xs) "1"))

(defn- invalid-area-code? [area-code]
  (or (= (first area-code) "0")
      (= (first area-code) "1")))

(defn- invalid-exchange-code? [exchange-code]
  (or (= "0" (first exchange-code))
      (= "1" (first exchange-code))))

(defn- completed-number [xs]
  (if (is-icc-code-valid? xs)
    (s/join "" (rest xs))
    invalid))

(defn- number-without-icc [xs]
  (let [exchange-code (take-last 7 xs)
        area-code (take 3 xs)]
    (if (or (invalid-exchange-code? exchange-code)
            (invalid-area-code? area-code))
      invalid
      (s/join "" xs))))

(defn number [num-string]
  (let [sequence (re-seq #"\w" num-string)]
    (cond
      (= (count sequence) 11) (completed-number sequence)
      (= (count sequence) 10) (number-without-icc sequence)
      :else invalid)))

(defn area-code [num-string]
  (let [xs (re-seq #"\w" num-string)]
    (if (= (count num-string) 11)
      (s/join "" (take 3 (rest xs)))
      (s/join "" (take 3 xs)))))

(defn- final-text [xs]
  (let [area-code (s/join "" (take 3 xs))
        exchange-code (s/join "" (take 3 (take-last 7 xs)))
        last-numbers (s/join "" (take-last 4 xs))]
    (str "(" area-code ")" " " exchange-code "-" last-numbers)))

(defn pretty-print [num-string]
  (let [xs (re-seq #"\w" num-string)]
    (if (= (count num-string) 11)
      (final-text (rest xs))
      (final-text xs))))

