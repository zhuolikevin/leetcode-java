/*
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three
 *
 * Easy (40.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '27'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) { return false; }
        while (n > 1) {
            int remain = n % 3;
            if (remain != 0) { return false; }
            n = n / 3;
        }
        return true;
    }
}
