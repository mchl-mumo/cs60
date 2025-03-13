#lang racket
(provide prefix? sublist?)


;; prefix?: checks if all the elements of one list appear consecutively at the start of another list
;;  inputs: list to check all elements from, P
;;          list to compare elements at start to, L
;;  output: #t if all elements of P are at the start of L, #f otherwise
(define (prefix? P L)
  (cond [(empty? P) #t]
        [(empty? L) #f]
        [(equal? (first P) (first L))
         (prefix? (rest P) (rest L))]
        [else #f]))

;;  sufix?: checks if all elements of one list appear consecutively within another list
;;  inputs: list to check all elements from, S
;;          list to compare elements from, L
;;  output: #t if all elements of S appear within L, #f otherwise
(define (sublist? S L)
  (cond [(empty? S) #t]
        [(empty? L) #f]
        [(prefix? S L) #t]
        [else (sublist? S (rest L))]))
