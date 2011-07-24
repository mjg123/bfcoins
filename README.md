# BrisFunctional LISP night

Dynamic programming exercise.

notes:
1/ this could stack overflow, use loop-recur
2/ we should memoize
3/ don't be GREEDY

advanced:
1/ What if the top were not a list of denominations, but a list of what we have RIGHT NOW, eg "1 2 5 5 2 50 100 2 10" ?
2/ Given #1, what if we had 2 targets to hit?
    coins:   1 2 2 5 5 10 10 10 50 100
    targets: 25 9
    result:  (10 10 5) (5 2 2) (1 10 50 100) <-- last is left overs
3/ This is one variation of the knapsack problem.  Another variation is known as the subset-sum problem:
    coins:   { −7, −3, −2, 5, 8}
    target:  0 <-- always is, in subset-sum.  Added constraint that the answer cannot be the empty set.
    answer: {-3, -2, 5}
