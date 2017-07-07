/*
 * [260] Single Number III
 *
 * https://leetcode.com/problems/single-number-iii
 *
 * Medium (51.12%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = new int[]{ 0, 0 };
        for (int num : nums) {
            if ((num & diff) > 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
