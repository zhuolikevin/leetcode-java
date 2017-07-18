/*
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n
 *
 * Medium (26.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '8.88023\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return Math.abs(x) == 1 ? 1 : 0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
