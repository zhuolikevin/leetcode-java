/*
 * [201] Bitwise AND of Numbers Range
 *
 * https://leetcode.com/problems/bitwise-and-of-numbers-range
 *
 * Medium (33.91%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        
        int base = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            base <<= 1;
        }
        
        return m * base;
    }
}
