/*
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position
 *
 * Easy (39.58%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) { continue; }
            else { return i; }
        }
        return nums.length;
    }
}
