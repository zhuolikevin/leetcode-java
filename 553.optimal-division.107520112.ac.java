/*
 * [553] Optimal Division
 *
 * https://leetcode.com/problems/optimal-division
 *
 * Medium (55.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1000,100,10,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) { return String.valueOf(nums[0]); }
        if (nums.length == 2) { return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]); }
        String res = String.valueOf(nums[0]) + "/(";
        for (int i = 1; i < nums.length - 1; i++) {
            res += String.valueOf(nums[i]) + "/";
        }
        res += String.valueOf(nums[nums.length - 1]) + ")";
        return res;
    }
}
