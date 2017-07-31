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
        if (k > nums.length) {
            return -1;
        }
        
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[left];
        int originLeft = left;
        int originRight = right;
        boolean toLeft = true;
        while (left < right) {
            if (toLeft) {
                if (nums[right] <= pivot) {
                    right--;
                } else {
                    nums[left] = nums[right];
                    left++;
                    toLeft = false;
                }
            } else {
                if (nums[left] > pivot) {
                    left++;
                } else {
                    nums[right] = nums[left];
                    right--;
                    toLeft = true;
                }
            }
        }
        nums[left] = pivot;
        
        int rank = left - originLeft + 1;
        if (rank == k) {
            return nums[left];
        } else if (rank < k) {
            return quickSelect(nums, left + 1, originRight, k - rank);
        } else {
            return quickSelect(nums, originLeft, left - 1, k);
        }
    }
}
