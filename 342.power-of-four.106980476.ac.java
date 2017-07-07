/*
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four
 *
 * Easy (38.32%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '16'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
