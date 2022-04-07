;; buy and item
(ns tutorial.coding-challenge-03)

(def pensPrice 1)
(def notebooksPrice 5)
(def backpacksPrice 10)

(def purchasedItems (ref (seq [])))
(def buyerAccount (ref 100))
(def merchantAccount (ref 0))

(defn updateInventory
  [price itemName]
  (if (>= @buyerAccount price)
    (dosync
      (def substract (- @buyerAccount price))
      (ref-set buyerAccount substract)
      (def add (+ @merchantAccount price))
      (ref-set merchantAccount add)
      (def purchased (conj @purchasedItems itemName))
      (ref-set purchasedItems purchased)
      )
    )
  (println "purchased items are: " @purchasedItems)
  (println "remain buyer money is: " @buyerAccount)
  (println "remain merchant money is: " @merchantAccount)
  )

(defn buyItems
  [itemsSeq]
  (doseq [itemName itemsSeq]
    (case itemName
      "pen" (updateInventory pensPrice "pen")
      "notebook" (updateInventory notebooksPrice "notebook")
      "backpack" (updateInventory  backpacksPrice "backpack")
      ))
  )

(buyItems ["pen", "backpack", "notebook"])


