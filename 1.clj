;; ============================================================================================
;; Напишите функцию, выбирающую из списка только элементы, встречающиеся более n-раз.

(defn selector 
    ([arr n] 
        (selector arr {} n))
    ([[h & tail :as arr] mapping n]
        (when-not (empty? arr)
            (if (contains? mapping h)
                (let [counts (get mapping h)]
                    (if (> counts n)
                        (recur tail mapping n)
                        (if (= counts n)
                            (cons h (lazy-seq (selector tail (assoc mapping h (inc counts)) n)))
                            (recur tail (assoc mapping h (inc counts)) n))))
                (recur tail (assoc mapping h 1) n)))))


(selector '(1 15 2 0 5 18 9 -11 24 11 11 -11 5 4 5 1 80 11 0 -12 15 18) 3)
