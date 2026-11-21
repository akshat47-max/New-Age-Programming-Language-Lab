
(defn custom-error []
  (throw (ex-info "Invalid age entered"
                  {:type :invalid-age
                   :age -5})))

(println "----- ARITHMETIC EXCEPTION -----")

(try
  (println "Result:" (/ 10 0))
  (catch ArithmeticException e
    (println "Error:" (.getMessage e)))
  (finally
    (println "Arithmetic Finally Block Executed")))


(println "\n----- NULL POINTER EXCEPTION -----")

(try
  (let [x nil]
    (.length x))
  (catch NullPointerException e
    (println "Error: Null value encountered"))
  (finally
    (println "Null Finally Block Executed")))


(println "\n----- CUSTOM EXCEPTION -----")

(try
  (custom-error)
  (catch clojure.lang.ExceptionInfo e
    (println "Error Message:" (ex-message e))
    (println "Error Data:" (ex-data e))
    (println "Recovery: Please enter a valid age"))
  (finally
    (println "Custom Finally Block Executed")))

(println "\nProgram continues normally")
