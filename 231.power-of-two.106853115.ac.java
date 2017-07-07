/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two
 *
 * Easy (39.97%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) { return false; }
        while (n > 1) {
            if (n % 2 == 1) { return false; }
            n >>= 1;
        }
        return true;
    }
}
