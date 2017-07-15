/*
 * [80] Remove Duplicates from Sorted Array II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * Medium (35.81%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int slow = 0;
        int fast = 0;
        Integer prev = null;
        int count = 0;
        while (fast < nums.length) {
            if (prev == null || nums[fast] != prev || nums[fast] == prev && count < 2) {
                if (prev != null && nums[fast] != prev) {
                    count = 0;
                }
                count++;
                prev = nums[fast];
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
                fast++;
            }
        }
        
        return slow;
    }
}
