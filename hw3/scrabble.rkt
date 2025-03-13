#lang racket

(provide subbag? best-word)
(require rackunit)


;;  subbag: checks if all the elements of S are in B 
;;  input: 2 lists, S and B
;;  output: #t if all the elements of S are in B and #f otherwise
(define (subbag? S B)
  (cond [(empty? S) #t]
        [(empty? B) #f]
        [(member (first S) B) (subbag? (rest S) (remove (first S) B))]
        [else #f]))


;;  best-word: returns the top scoring scrabble word from a given rack 
;;  inputs: a string of letters, rack
;;          a list of allowed words, WL
;;  output: a list with the highest scoring word and its score
(define (best-word rack WL)
  (if (empty? WL)
      '("" 0)
      (if (> (second(first (words-scores rack WL))) (second(best-word rack (rest WL))))
         (first (words-scores rack WL))
         (best-word rack (rest WL)))))

;; scrabble-tile-bag  
;;   letter tile scores and counts from the game of Scrabble
;;   the counts are not needed
;;   obtained from http://en.wikipedia.org/wiki/Image:Scrabble_tiles_en.jpg
(define scrabble-tile-bag
  '((#\a 1 9) (#\b 3 2) (#\c 3 2) (#\d 2 4) (#\e 1 12)
   (#\f 4 2) (#\g 2 3) (#\h 4 2) (#\i 1 9) (#\j 8 1)
   (#\k 5 1) (#\l 1 4) (#\m 3 2) (#\n 1 6) (#\o 1 8)
   (#\p 3 2) (#\q 10 1)(#\r 1 6) (#\s 1 4) (#\t 1 6)
   (#\u 1 4) (#\v 4 2) (#\w 4 2) (#\x 8 1) (#\y 4 2)
   (#\z 10 1) (#\_ 0 2)) ) 
;; end define scrabble-tile-bag
;; The underscore is used to represent a blank tile, which is a wild-card



;;  words-scores: creates a list of pairs with each word paired with its scrabble score
;;  inputs:list of allowed words, WL
;;         string of utilizable letters, rack
;;  output: a list of list with each word paired with its score
(define (words-scores rack WL)
  (if (empty? WL)
      '()
      (cons (list (first WL) (first (WL_score rack WL))) (words-scores rack (rest WL)))))


;;  WL_score: computes the sum of the score of words in a list
;;  input: a list of words
;;  output: a list of integers with corresponding scores of words in the input list
(define (WL_score rack WL)
  (cond [(empty? WL) '()]
        [(subbag? (string->list (first WL)) (string->list rack)) (cons(score-word (first WL)) (WL_score rack (rest WL)))]
        [else (cons 0 (WL_score rack (rest WL)))]))


;;  score-word: computes the sum of the score of letters in a word 
;;  input: a string of letters
;;  output: integer score of the word
(define (score-word word)
  (let ([word
         (if (list? word)
             word
             (string->list word))])
  (if (empty? word)
      0
      (+ (score-letter (first word)) (score-word (rest word))))))


;;  score-letter: checks the score of a letter from the scrabble-tile-bag
;;  input: a character, letter
;;  output: integer score of the given letter
(define (score-letter letter)
  (second(assoc letter scrabble-tile-bag)))


(check-equal? (score-letter '#\w) 4)
(check-equal? (score-word "zzz")  30)
(check-equal? (score-word "fortytwo") 17)
(check-equal? (score-word "twelve")  12)






