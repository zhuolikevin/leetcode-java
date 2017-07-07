/*
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence
 *
 * Medium (38.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] count = new int[nums.length];
        count[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    temp = Math.max(temp, count[j] + 1);
                }
            }
            count[i] = temp;
        }
        
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        
        return max;
    }
}
