/*
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break
 *
 * Medium (45.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) { return 1; }
        if (n == 3) { return 2; }
        int prod = 1;
        while (n > 4) {
            prod *= 3;
            n -= 3;
        }
        prod *= n;
        return prod;
    }
}
