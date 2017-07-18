/*
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers
 *
 * Easy (29.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= (int)Math.sqrt(c); i++) {
            int temp = c - i * i;
            int sq = (int)Math.sqrt(temp);
            if (sq * sq == temp) { return true; }
        }
        return false;
    }
}
