#lang racket

(require rackunit)
(require "indivisible.rkt")

; student tests
(check-equal? (indivisible 2 '(1 4)) '(1))
(check-equal? (indivisible 2 '(2 4 6)) '())
(check-equal? (indivisible 1 '()) '())

; provided tests
(check-equal? (indivisible 3 '(2 3 4 5 6 7 8 9 10 )) '(2 4 5 7 8 10))