(ns tutorial.exceptions)

(defn ExHandling
  [x]
  (try
    (inc x)
    (catch ClassCastException e (println "Caught ClassCastException: " (.getMessage e)))
    (catch Exception e (println "Caught Generic Exception: " (.getMessage e)))
    (finally (println "cleanup and move on"))
    ))
(ExHandling "hello")