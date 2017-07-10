/*
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array
 *
 * Medium (53.64%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        if (nums[1] != nums[0]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid - 1] == nums[mid]) {
                if ((nums.length - 1 - mid) % 2 == 0) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if ((mid - 0) % 2 == 0) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] != nums[left - 1] && nums[left] != nums[left + 1]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}
