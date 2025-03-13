#lang racket

(require rackunit)
(require "prefix_sublist.rkt")

; student tests
(check-true  (prefix? '() '()))
(check-false  (prefix? '(s) '()))
(check-false  (prefix? '(s p a m) '(s)))

(check-true  (sublist? '() '()))
(check-false  (sublist? '(s) '()))
(check-false  (sublist? '(s p a m) '(s)))
(check-false (sublist? '(s m a) '(s p a m)))


; provided tests
(check-true  (prefix? '()    '(s p a m)))
(check-true  (prefix? '(s p) '(s p a m)))
(check-false (prefix? '(s m) '(s p a m)))
(check-false (prefix? '(p a) '(s p a m)))

(check-true  (sublist? '()    '(s p a m)))
(check-true  (sublist? '(s p) '(s p a m)))
(check-false (sublist? '(s m) '(s p a m)))
(check-true  (sublist? '(p a) '(s p a m)))