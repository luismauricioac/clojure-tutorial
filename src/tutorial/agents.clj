(ns tutorial.agents)

(defn Agents
  []
  (def amount (agent 100))
  (println @amount)

  (send amount inc)
  (println @amount)
  (delay (println "some time must pass") 20000)
  (println @amount)

  (send amount inc)
  (await-for 10000 amount)
  (println @amount)

  (println (agent-error amount))
  )
(Agents)
