/*
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number
 *
 * Medium (43.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findDuplicate(int[] nums) {
    	if (nums.length <= 1) { return -1; }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
