#lang racket

(provide superreverse duperreverse)


;;  superreverse: reverses the top level lists in a list of lists 
;;  input: a list of lists, L
;;  output: a lists of lists with reversed elements in the inner lists
(define (superreverse L)
  (if (empty? L)
      '()
      (cons (reverse (first L)) (superreverse (rest L)))))

;;  duperreverse: reverses all the lists in a list of lists
;;  input: a list of elements with some nested lists, L
;;  output: a list of lists with all lists reversed
(define (duperreverse L)
  (cond [(empty? L) '()]
        [(list? (first L))
         (append (duperreverse (rest L))
                 (list (duperreverse(first L))))]
        [else
         (append (duperreverse(rest L))
                 (list (first L)))]))