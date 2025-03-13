#lang racket

(require rackunit)
(require "remove-all.rkt")


; student tests
(check-equal? (remove-all "a" '("a")) '() )
(check-equal? (remove-all "a" '()) '() )
(check-equal? (remove-all "b" '("a")) '("a") )
(check-equal? (remove-all "a" '("a" "b")) '("b") )
(check-equal? (remove-all "a" '("a" "a")) '() )
(check-equal? (remove-all "" '("a")) '("a") )

; provided tests
(check-equal? (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) 
              '("a" "l" "e" "n"))
(check-equal? (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) 
              '(("a" "l" "i") "e" "n"))
(check-equal? (remove-all 0 '(1 0 1 0 1 0))  
              '(1 1 1))

