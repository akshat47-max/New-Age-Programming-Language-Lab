
;; Exp 18: Sequence Transformations

;; Collection 1: List
(def numbers '(1 2 3 4 5 6))

(println "----- LIST OPERATIONS -----")
(println "Original List:" numbers)

;; 1. MAP - Square each element
(println "Squares:" (map #(* % %) numbers))

;; 2. FILTER - Select even numbers
(println "Even Numbers:" (filter even? numbers))

;; 3. REDUCE - Calculate sum
(println "Sum:" (reduce + numbers))

;; 4. TAKE and DROP
(println "Take First 3:" (take 3 numbers))
(println "Drop First 3:" (drop 3 numbers))

;; Threading macro: chain operations
(println "Chained Result:"
         (->> numbers
              (filter even?)
              (map #(* % %))
              (take 2)))


;; Collection 2: Vector
(def values [10 15 20 25 30])

(println "\n----- VECTOR OPERATIONS -----")
(println "Original Vector:" values)

(println "Squares:" (map #(* % %) values))

(println "Even Numbers:" (filter even? values))

(println "Maximum:" (reduce max values))

(println "Take First 2:" (take 2 values))
(println "Drop First 2:" (drop 2 values))

;; Threading macro
(println "Chained Result:"
         (->> values
              (filter even?)
              (map inc)
              (take 2)))
