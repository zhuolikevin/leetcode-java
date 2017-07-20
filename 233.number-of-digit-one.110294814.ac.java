/*
 * [233] Number of Digit One
 *
 * https://leetcode.com/problems/number-of-digit-one
 *
 * Hard (28.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '-1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, (long)0), i);
        }
        return count;
    }
}
