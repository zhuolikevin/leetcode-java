/*
 * [26] Remove Duplicates from Sorted Array
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 *
 * Easy (35.53%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) { return nums.length; }
        int slow = 1;
        while (slow < nums.length && nums[slow] != nums[slow-1]) {
            slow++;
        }
        if (slow == nums.length) { return slow; }
        
        int fast = slow + 1;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == nums[slow-1]) {
                fast++;
            }
            if (fast == nums.length) { break; }
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            slow++;
            fast++;
        }
        return slow;
    }
}
