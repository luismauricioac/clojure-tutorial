(ns tutorial.coding-challenge-02)

(defn calculateDiscount
  [price discountPercentage]
  (- price (* price discountPercentage))
  )

(defn printPromo
  [couponValid budget, discountPercentage]
  (defstruct car :brand :price :hasDiscount)
  (def car1 (struct car "BMW" 60000 true))
  (def car2 (struct car "FERRARI" 100000 false))
  (def car3 (struct car "FIAT" 20000 true))
  (def cars (seq [car1 car2 car3]))

  (if couponValid
    (do (println "BUDGED" budget)
        (println "THE COUPON IS VALID")
        (doseq [c cars]
          (if (:hasDiscount c) (println (:brand c) (calculateDiscount (:price c) discountPercentage))))
        ))
  (if (not= couponValid true)
    (do (println "BUDGED" budget)
        (println "THE COUPON NOT VALID")
        (doseq [c cars]
          (if (= (:hasDiscount c) false) (println (:brand c) (:price c))))
        ))
  )

(defn CarDealership
  [budget code]

  (def couponName "20DISCOUNT")
  (def defaultBudget 50000)
  (def discountPercentage 0.20)

  (cond
    (and (>= budget defaultBudget) (= code couponName)) (printPromo true budget discountPercentage)
    (and (< budget defaultBudget) (= code couponName)) (printPromo false budget discountPercentage)
    (and (>= budget defaultBudget) (not= code couponName)) (printPromo false budget discountPercentage)
    :else (println "Loads")
    ))
(CarDealership 50000 "20DISCOUNT")
(CarDealership 30000 "20DISCOUNT")
(CarDealership 51000 "ANOTHER")