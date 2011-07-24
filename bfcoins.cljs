(ns bfcoins
  (:require [goog.dom :as dom]
            [goog.events :as events]))

;; DEBUG stuff

(defn js-alert [msg]
  ((js* "alert") msg))

(defn clj-alert [msg]
  (js-alert (pr-str msg)))

;; DOM stuff

(defn get-coins 
  "Parse the coins string out of the browser, return sorted largest first"
  []
  (let [coin-str (.value (dom/getElement "coins"))
        coins-as-str (.split coin-str " ")
        coins (map #(* 1 %) coins-as-str)]
    (reverse (sort coins))))

(defn get-target []
  (.value (dom/getElement "target")))

(defn write-answer [answer]
  (set! (.innerHTML (dom/getElement "results")) 
        (pr-str answer)))

(defn dom-calculate []
  (write-answer
    (calculate (get-coins) (get-target))))

(events/listen (dom/getElement "do-calculation")
               "click"
               dom-calculate)

;; REAL code

(defn max-coin
  "Return the largest coin which is <= target"
  [coins target]
  (first (filter #(>= target %) coins)))

(defn calculate [coins target]
  (let [coin (max-coin coins target)]
    (cond
      (= coin target) (list coin)
      :else (conj (calculate coins (- target coin)) coin))))
