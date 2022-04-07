(ns tutorial.macros)

;; under the hood it converts to if
(macroexpand-1 '(when true (println "hello")))
