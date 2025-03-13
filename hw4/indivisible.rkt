#lang racket

(provide indivisible)


;;   superreverse: checks for elements in a list that are indivisible by a given integer
;;   inputs: list of positive integers, L
;;           positive integer, e
;;   output: list containing elements in L that are indivisible by e
(define (indivisible e L)
  (filter (lambda (x) (> (modulo x e) 0)) L))