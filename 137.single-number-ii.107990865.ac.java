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
        for (int c : nums) {
            int ta = (~a & b & c) | (a & ~b & ~c);
            b = (~a & ~b & c) | (~a & b & ~c);
            a = ta;
        }
        return a | b;
    }
}
