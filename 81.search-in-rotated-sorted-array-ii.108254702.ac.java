/*
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 *
 * Medium (32.78%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else  {
                    start = mid;
                }
            } else if (nums[mid] < nums[start]) {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else  {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}
