/*
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 *
 * Medium (39.62%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
