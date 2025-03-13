#lang racket

(provide count1bits)


;; count1bits the "count1bits" function
;;   input: a positive decimal integer, N
;;   output: integer of number of 1s in N as a binary
(define (count1bits N)

  (let
    ([rem (remainder N 2)]
     [quot (quotient N 2)])
  (cond
    [(equal? N 0) 0]
    [(equal? rem 1) (+ 1 (count1bits quot))]
    [(equal? rem 0) (+ 0 (count1bits quot))])))
