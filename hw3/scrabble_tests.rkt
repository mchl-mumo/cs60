#lang racket

(require rackunit)
(require "scrabble.rkt")

; student tests
(check-true  (subbag? '(d a d) '(a d d)) )
(check-false (subbag? '(d a d) '()) )
(check-false (subbag? '(d a d a) '(d a d)) )


(check-equal? (best-word "a" '("a" ))
 '("a" 1))
(check-equal? (best-word "a" '("a" "b"))
 '("a" 1))
(check-equal? (best-word "ab" '("a" "b"))
 '("b" 3))
(check-equal? (best-word "ab" '("a" "ab"))
 '("ab" 4))
(check-equal? (best-word "abc" '("ab" "abc" "abc" "a" ))
 '("abc" 7))


; provided tests
(check-true  (subbag? '()      '(s p a m s)) )
(check-true  (subbag? '(s s)   '(s p a m s)) )
(check-true  (subbag? '(s m)   '(s p a m s)) )
(check-true  (subbag? '(a p)   '(s p a m s)) )
(check-false (subbag? '(a m a) '(s p a m s)) )
(check-true  (subbag? '(a s)   '(s a))       )

(check-equal? (best-word "academy" '("ace" "ade" "cad" "cay" "day")) 
 '("cay" 8))
(check-equal? (best-word "appler"  '("peal" "peel" "ape" "paper")) 
 '("paper" 9))
(check-equal? (best-word "paler"   '("peal" "peel" "ape" "paper"))
 '("peal" 6))
(check-equal? (best-word "kwyjibo" '("ace" "ade" "cad" "cay" "day"))
 '("" 0))