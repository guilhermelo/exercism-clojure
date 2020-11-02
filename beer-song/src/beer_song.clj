(ns beer-song)

(defn- define-bottle
  ([n-bottle]
   (cond
     (= n-bottle 0) "no more bottles"
     (< n-bottle 0) "99 bottles"
     (> n-bottle 1) (str n-bottle " bottles")
     :else (str n-bottle " bottle")))
  ([n-bottle _]
   (cond
     (<= n-bottle 0) "No more bottles"
     (> n-bottle 1) (str n-bottle " bottles")
     :else (str n-bottle " bottle"))))

(defn- define-phrase [n-bottle]
  (cond
    (< n-bottle 1) "Go to the store and buy some more"
    (> n-bottle 1) "Take one down and pass it around"
    :else "Take it down and pass it around"))

(defn verse
  "Returns the nth verse of the song."
  [num]
  (str (define-bottle num "") " of beer on the wall, " (define-bottle num) " of beer.\n"
       (define-phrase num) ", " (define-bottle (dec num)) " of beer on the wall.\n"))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (let [nums (reverse (range end (inc start)))]
     (reduce (fn [final-text number]
               (str final-text (verse number) (if (= (last nums) number) "" "\n"))) "" nums))))