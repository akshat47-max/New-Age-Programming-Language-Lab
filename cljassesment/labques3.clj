
(def database (atom []))

(defn add-student [name marks]
  (try
    (swap! database conj {:name name :marks marks})
    (println "Student added successfully")
    (catch Exception e
      (println "Error:" (.getMessage e)))))

(defn show-students []
  (try
    (doseq [student @database]
      (println student))
    (catch Exception e
      (println "Error:" (.getMessage e)))))

(add-student "Rahul" 85)
(add-student "Priya" 90)
(add-student "Aman" 35)

(println "Student Records:")
(show-students)
