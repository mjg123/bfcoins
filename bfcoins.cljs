(ns bfcoins
  (:require [goog.dom :as dom]
            [goog.events :as events]))

;; DEBUG stuff

(defn js-alert [msg]
  ((js* "alert") msg)
  nil)

(defn clj-alert [msg]
  (js-alert (pr-str msg)))

;; DOM stuff

(defn get-coins []
  "Parse the coins string out of the browser, return sorted largest first"
  (let [coins-as-strs  (-> (dom/getElement "coins")
                           (.value)
                           (.split " "))
        non-zero-coins (->> coins-as-strs
                            (map #(* 1 %))
                            (filter #(not= 0 %)))]
    (reverse (sort non-zero-coins))))

(defn get-target []
  (* 1 (.value (dom/getElement "target"))))

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
      (= coin nil)    (js-alert "No solution")
      (= coin target) (list coin)
      (< coin target) (conj (calculate coins (- target coin)) coin))))
