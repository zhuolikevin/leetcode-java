/*
 * [374] Guess Number Higher or Lower
 *
 * https://leetcode.com/problems/guess-number-higher-or-lower
 *
 * Easy (34.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '10\n6'
 *
 * Can you solve this problem? 🤔
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return guess(left) == 0 ? left : right;
    }
}
