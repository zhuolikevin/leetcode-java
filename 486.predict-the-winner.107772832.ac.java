/*
 * [486] Predict the Winner
 *
 * https://leetcode.com/problems/predict-the-winner
 *
 * Medium (44.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,5,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1, 0, true);
    }
    
    private boolean helper(int[] nums, int left, int right, int leadBy, boolean firstPlayer) {
        if (left == right) {
            if (firstPlayer) { return leadBy + nums[left] >= 0; }
            else { return leadBy + nums[left] > 0; }
        }
        return !helper(nums, left + 1, right, - leadBy - nums[left], !firstPlayer) ||
            !helper(nums, left, right - 1, - leadBy - nums[right], !firstPlayer);
    }
}
