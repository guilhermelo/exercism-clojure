(ns run-length-encoding)

(defn- list-joined [xs]
  (map (fn [inner-xs]
         (let [amount (count inner-xs)
               item (first inner-xs)]
           (if (= 1 amount)
             (str item)
             (str amount item)))) xs))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (let [xs (partition-by identity (clojure.string/split plain-text #""))
        joined-list (list-joined xs)
        result (reduce (fn [final x] (str final x)) joined-list)]
    result))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d+)?(\D)")
       (mapcat (fn [[_ times character]]
                 (repeat (Integer/parseInt (or times "1")) character)))
       (apply str)))