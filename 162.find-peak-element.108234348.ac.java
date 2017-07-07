/*
 * [162] Find Peak Element
 *
 * https://leetcode.com/problems/find-peak-element
 *
 * Medium (37.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return -1;
        }
        if (len == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 1] > nums[len - 2]) {
            return len - 1;
        }
        
        int start = 0;
        int end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1] && (mid == 0 || nums[mid] > nums[mid - 1])) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] > nums[start + 1] && (start == 0 || nums[start - 1] < nums[start])) {
            return start;
        } else if (nums[end] > nums[end - 1] && (end == len - 1 || nums[end] < nums[end + 1])) {
            return end;
        } else {
            return -1;
        }
    }
}
