# BrisFunctional LISP night

Dynamic programming exercise.


advanced:

1/ What if the top were not a list of denominations, but a list of what we have RIGHT NOW, eg "1 2 5 5 2 50 100 2 10" ?

2/ Given #1, what if we had 2 targets to hit?
    coins:   1 2 2 5 5 10 10 10 50 100
    targets: 25 9
    result:  (10 10 5) (5 2 2) (1 10 50 100) <-- last is left overs

3/ That is one variation of the knapsack problem.  Another variation is known as the subset-sum problem:
    coins:   { −7, −3, −2, 5, 8}
    target:  0 <-- always is, in subset-sum.  Added constraint that the answer cannot be the empty set.
    answer: {-3, -2, 5}


---

asked about this on the clojure irc channel:

https://gist.github.com/1074857/0f32b3d64cd7641ef975f8fa6e08f26518a6cae4
https://gist.github.com/1074808
https://gist.github.com/1074818

(last is apparently fastest, and is definitely easiest to understand)


Lisp 1957