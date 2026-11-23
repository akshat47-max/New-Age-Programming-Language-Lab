
(defn my-handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Student Performance System is Running!"})

(println (my-handler {}))
