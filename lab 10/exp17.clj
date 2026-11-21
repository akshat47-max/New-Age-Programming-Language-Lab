
;; 1. LIST
(println "----- LIST -----")

(def my-list '(10 20 30 40))

(println "Original List:" my-list)
(println "First Element:" (first my-list))
(println "Rest of List:" (rest my-list))

(def new-list (conj my-list 5))

(println "New List after conj:" new-list)
(println "Original List unchanged:" my-list)


;; 2. VECTOR
(println "\n----- VECTOR -----")

(def my-vector [10 20 30])

(println "Original Vector:" my-vector)
(println "Element at index 1:" (get my-vector 1))
(println "Count:" (count my-vector))

(def new-vector (conj my-vector 40))

(println "New Vector:" new-vector)
(println "Original Vector unchanged:" my-vector)


;; 3. MAP
(println "\n----- MAP -----")

(def my-map {:name "Rahul" :age 21 :city "Delhi"})

(println "Original Map:" my-map)
(println "Get Name:" (get my-map :name))

(def updated-map (assoc my-map :age 22))
(println "After assoc:" updated-map)

(def removed-map (dissoc my-map :city))
(println "After dissoc:" removed-map)

(println "Original Map unchanged:" my-map)


;; 4. SET
(println "\n----- SET -----")

(def my-set #{10 20 30})

(println "Original Set:" my-set)
(println "Contains 20:" (contains? my-set 20))

(def new-set (conj my-set 40))
(println "After conj:" new-set)

(def removed-set (disj my-set 10))
(println "After disj:" removed-set)

(println "Original Set unchanged:" my-set)
