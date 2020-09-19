(ns bob
  (:require [clojure.string :as s]))

(defn- upper-case? [text]
  (= text (s/upper-case text)))

(defn- yell? [text]
  (and (upper-case? text)
       (some #(Character/isLetter %) text)))

(defn- question? [text]
  (s/ends-with? (s/trim text) "?"))

(defn- has-no-words? [text]
  (or (s/blank? (s/trim text))))

(defn response-for [s]
  (let [y (yell? s)
        q (question? s)]
    (cond
      (has-no-words? s) "Fine. Be that way!"
      (and q y) "Calm down, I know what I'm doing!"
      q "Sure."
      y "Whoa, chill out!"
      :else "Whatever.")))




