/*
 * [55] Jump Game
 *
 * https://leetcode.com/problems/jump-game
 *
 * Medium (29.47%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, nums[i] + i);
        }
        
        return true;
    }
}
