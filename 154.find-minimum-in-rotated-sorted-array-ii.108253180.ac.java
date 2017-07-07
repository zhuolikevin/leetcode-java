/*
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
 *
 * Hard (36.91%)
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
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                int temp = nums[mid];
                while (end > mid && nums[end] == temp) {
                    end--;
                }
                if (end != mid) {
                    start = mid;
                }
            }
        }
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
