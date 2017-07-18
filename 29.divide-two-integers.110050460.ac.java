/*
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers
 *
 * Medium (15.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        
        long res = sign * helper(ldividend, ldivisor);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }
    
    private long helper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        
        long sum = divisor;
        long multiple = 1;
        while (sum * 2 <= dividend) {
            sum *= 2;
            multiple *= 2;
        }
        
        return multiple + helper(dividend - sum, divisor);
    }
}
