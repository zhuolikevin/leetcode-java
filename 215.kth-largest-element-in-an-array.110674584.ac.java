/*
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 *
 * Medium (38.91%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k <= 0) {
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int originLeft = left;
        int originRight = right;
        int temp = nums[left];
        boolean toLeft = true;
        while (left < right) {
            if (toLeft) {
                if (nums[right] <= temp) {
                    nums[left] = nums[right];
                    left++;
                    toLeft = false;
                } else {
                    right--;
                }
            } else {
                if (nums[left] >= temp) {
                    nums[right] = nums[left];
                    right--;
                    toLeft = true;
                } else {
                    left++;
                }
            }
        }
        nums[left] = temp;
        
        int rank = originRight - right + 1;
        if (rank == k) {
            return nums[left];
        } else if (rank > k) {
            return quickSelect(nums, left + 1, originRight, k);
        } else {
            return quickSelect(nums, originLeft, right - 1, k - rank);
        }
    }
}
