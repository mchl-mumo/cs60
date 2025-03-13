#lang racket

(require rackunit)
(require "power.rkt")

; provided tests
(check-equal? (power 2 10) 1024)
(check-equal? (power 42 10) 17080198121677824)

(check-equal? (fast-power 2 10) 1024)
(check-equal? (fast-power 42 10) 17080198121677824)

; student tests
(check-equal? (power 3 5) 243)
(check-equal? (power 8 2) 64)

(check-equal? (fast-power 3 5) 243)
(check-equal? (fast-power 8 2) 64)



(time (power 2 100000) (void))
(time (fast-power 2 100000) (void))