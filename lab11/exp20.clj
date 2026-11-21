
(println "----- JAVA STATIC METHODS -----")

(println "Absolute Value:" (Math/abs -25))
(println "Square Root:" (Math/sqrt 64))
(println "Current Time:" (System/currentTimeMillis))


(println "\n----- JAVA OBJECT CREATION -----")

(def arr (new java.util.ArrayList))

(.add arr "Apple")
(.add arr "Banana")
(.add arr "Mango")

(println "ArrayList:" arr)
(println "First Element:" (.get arr 0))
(println "Size:" (.size arr))


(def hm (new java.util.HashMap))

(.put hm "Name" "Rahul")
(.put hm "Age" 21)
(.put hm "City" "Delhi")

(println "HashMap:" hm)
(println "Name:" (.get hm "Name"))
(println "Size:" (.size hm))


(println "\n----- COLLECTION CONVERSION -----")

(def clj-vector [10 20 30 40])

(def java-list (java.util.ArrayList. clj-vector))

(println "Clojure Vector:" clj-vector)
(println "Java ArrayList:" java-list)

(def converted-vector (vec java-list))

(println "Converted Clojure Vector:" converted-vector)


(def clj-map {:a 1 :b 2 :c 3})

(def java-map (java.util.HashMap. clj-map))

(println "Clojure Map:" clj-map)
(println "Java HashMap:" java-map)

(def converted-map (into {} java-map))

(println "Converted Clojure Map:" converted-map)
