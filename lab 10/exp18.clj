
(def numbers '(1 2 3 4 5 6))

(println "----- LIST OPERATIONS -----")
(println "Original List:" numbers)
(println "Squares:" (map #(* % %) numbers))
(println "Even Numbers:" (filter even? numbers))
(println "Sum:" (reduce + numbers))
(println "Take First 3:" (take 3 numbers))
(println "Drop First 3:" (drop 3 numbers))

(println "Chained Result:"
         (->> numbers
              (filter even?)
              (map #(* % %))
              (take 2)))

(def values [10 15 20 25 30])

(println "\n----- VECTOR OPERATIONS -----")
(println "Original Vector:" values)
(println "Squares:" (map #(* % %) values))
(println "Even Numbers:" (filter even? values))
(println "Maximum:" (reduce max values))
(println "Take First 2:" (take 2 values))
(println "Drop First 2:" (drop 2 values))

(println "Chained Result:"
         (->> values
              (filter even?)
              (map inc)
              (take 2)))
