
(ns student-performance
  (:import [java.util Date]))

(def students
  [{:name "Rahul" :marks 85}
   {:name "Aman" :marks 35}
   {:name "Priya" :marks 90}
   {:name "Rohan" :marks 60}
   {:name "Neha" :marks 25}])

(println "STUDENT PERFORMANCE DATA PIPELINE")

(println "\nStudent Names:")
(println (map :name students))

(def passed
  (filter #(>= (:marks %) 40) students))

(println "\nPassed Students:")
(println passed)

(def total
  (reduce + (map :marks students)))

(println "\nTotal Marks:" total)
(println "Average Marks:" (/ total (count students)))

(def database (atom []))

(defn add-student [name marks]
  (try
    (swap! database conj {:name name :marks marks})
    (println "Student added successfully")
    (catch Exception e
      (println "Database Error:" (.getMessage e)))))

(defn show-students []
  (try
    (println "\nDatabase Records:")
    (doseq [s @database]
      (println s))
    (catch Exception e
      (println "Read Error:" (.getMessage e)))))

(add-student "Rahul" 85)
(add-student "Priya" 90)
(add-student "Aman" 35)

(show-students)

(defn my-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (str "Total Students: " (count students)
              ", Passed Students: " (count passed))})

(println "\nHTTP Response:")
(println (my-handler {}))

(def today (Date.))

(println "\nToday's Date:")
(println today)

(println "\nApplication Completed Successfully!")
