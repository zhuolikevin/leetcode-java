/*
 * [45] Jump Game II
 *
 * https://leetcode.com/problems/jump-game-ii
 *
 * Hard (26.14%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curEnd = 0;
        int curFarthest = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                count++;
                curEnd = curFarthest;
            }
        }
        return count;
    }
}
