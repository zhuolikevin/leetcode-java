/*
 * [137] Single Number II
 *
 * https://leetcode.com/problems/single-number-ii
 *
 * Medium (41.20%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            int temp = a;
            a = a & (~b) & (~num) | (~a) & b & num;
            b = (~temp) & b & (~num) | (~temp) & (~b) & num;
        }
        
        return a | b;
    }
}
