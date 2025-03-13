#lang racket

(provide superreverse)


;; superreverse: reverses the top level lists in a list of lists
;;   input:  a list of lists, L
;;   output: list of lists containing reversed top level lists of L
(define (superreverse L)
  (map reverse L))

