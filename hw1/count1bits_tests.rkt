#lang racket

(require rackunit)
(require "count1bits.rkt")   

; student tests
(check-equal? (count1bits 51) 4)
(check-equal? (count1bits 8) 1)

; provided tests
(check-equal? (count1bits 6) 2)
(check-equal? (count1bits 7) 3)
(check-equal? (count1bits 42) 3)
