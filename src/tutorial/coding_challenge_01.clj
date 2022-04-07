(ns tutorial.coding-challenge-01
  (:gen-class))

(def pet_factor {"DOG" 7 "CAT" 5 "FISH" 10})

(def age_in_human_years (fn [pet, age] (* (pet_factor pet) age)))

(println "Age for a dog")
(println (age_in_human_years "DOG" 1))

(println "Age for a cat")
(println (age_in_human_years "CAT" 1))

(println "Age for a fish")
(println (age_in_human_years "FISH" 1))