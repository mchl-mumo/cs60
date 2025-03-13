#lang racket

(provide enumerate)

;; enumerate: creates an association list of index and element
;;  input: list of elements, L
;;  output: list of lists of element with index
(define (enumerate L)
  ;; index pairs each element with its index
  (define (index L n)
    (if (empty? L)
      '()
       (cons (list n (first L)) (index (rest L) (+ n 1)))))
  (index L 0))


      



  
  

