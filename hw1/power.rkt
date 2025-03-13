#lang racket

(provide power fast-power)

(define (power base pow)
  (if (equal? 0 pow)
      1
      (* base (power base (- pow 1)))))



(define (fast-power base pow)
  (cond
    [(equal? pow 0) 1]
    [(odd? pow) (* base (fast-power base (- pow 1)))]
    [(even? pow)
       (let*   
           ([halfpower (quotient pow 2)]
            [evenhalf (fast-power base halfpower)])
       (* evenhalf evenhalf))]))




