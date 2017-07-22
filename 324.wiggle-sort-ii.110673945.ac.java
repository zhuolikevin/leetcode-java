/*
 * [324] Wiggle Sort II
 *
 * https://leetcode.com/problems/wiggle-sort-ii
 *
 * Medium (25.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,5,1,1,6,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 3) {
            return;
        }
        
        int n = nums.length;
        int median = findKthLargest(nums, n / 2);
        int left = 0;
        int right = n - 1;
        int i = 0;
        while (i <= right) {
            if (nums[getMappedIndex(i, n)] > median) {
                swap(nums, getMappedIndex(i, n), getMappedIndex(left, n));
                left++;
                i++;
            } else if (nums[getMappedIndex(i, n)] < median) {
                swap(nums, getMappedIndex(i, n), getMappedIndex(right, n));
                right--;
            } else {
                i++;
            }
        }
    }
    
    private int getMappedIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
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
                    toLeft = false;
                } else {
                    right--;
                }    
            } else {
                if (nums[left] > temp) {
                    nums[right] = nums[left];
                    toLeft = true;
                } else {
                    left++;
                }
            }
        }
        nums[left] = temp;
        
        int rank = originRight - right + 1;
        if (rank == k) {
            return temp;
        } else if (rank < k) {
            return quickSelect(nums, originLeft, right - 1, k - rank);
        } else {
            return quickSelect(nums, left + 1, originRight, k);
        }
    }
}
