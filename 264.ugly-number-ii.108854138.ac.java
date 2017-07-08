/*
 * [264] Ugly Number II
 *
 * https://leetcode.com/problems/ugly-number-ii
 *
 * Medium (32.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int nthUglyNumber(int n) {        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indices = new int[] { 0, 0, 0 };
        int[] originFactors = new int[] { 2, 3, 5 };
        int[] factors = new int[] { 2, 3, 5 };
        
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factors[0], factors[1]), factors[2]);
            ugly[i] = min;
            for (int j = 0; j < 3; j++) {
                if (factors[j] == min) {
                    indices[j]++;
                    factors[j] = originFactors[j] * ugly[indices[j]];
                }
            }
        }
        
        return ugly[n - 1];
    }
}
