
(def students
  [{:name "Rahul" :marks 85}
   {:name "Aman" :marks 35}
   {:name "Priya" :marks 90}
   {:name "Rohan" :marks 60}
   {:name "Neha" :marks 25}])

(println "Student Names:")
(println (map :name students))

(println "\nPassed Students:")
(println (filter #(>= (:marks %) 40) students))

(def total (reduce + (map :marks students)))

(println "\nTotal Marks:" total)
(println "Average Marks:" (/ total (count students)))
