(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot! Dafuq"))


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})


(defn symmetrize-body-parts
  [asym-body-parts]
  (reduce
   (fn [final-parts part]
     (into final-parts (set [part (matching-part part)])))
   []
   asym-body-parts))

(defn hit
  []
  (let [all-parts (symmetrize-body-parts asym-hobbit-body-parts)
        target (rand-int (reduce + (map :size all-parts)))]
    (loop [acumulated-size (:size (first all-parts)) [part & remaining-parts] all-parts]
      (if (> acumulated-size target)
        (:name part)
        (recur (+ acumulated-size (:size part)) remaining-parts)))))

(hit)

(str "Hello" " World")
(vector 3 4 6 7 18 25)
(list 3 4 6 7 18 25)
(hash-map :age 12 "name" "cazuza")
(hash-set 11 1 1 2 4 5 2)

(defn adds-one-hundred
  [number]
  (+ number 100))

(adds-one-hundred 10)

(defn dec-maker
  [dec-amount]
  (fn [num]
    (- num dec-amount)))

(def dec9 (dec-maker 9))

(dec9 100)

(defn mapset
  [f vector]
  (let
   [newSet (set vector)]
    (set (map f newSet))))

(mapset inc [1 1 2 2])


