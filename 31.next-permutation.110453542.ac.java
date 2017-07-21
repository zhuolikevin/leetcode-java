/*
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation
 *
 * Medium (28.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }
        
        int toReplace = nums[i - 1];
        for (int j = nums.length - 1; j >= i; j--) {
            if (nums[j] > toReplace) {
                nums[i - 1] = nums[j];
                nums[j] = toReplace;
                break;
            }
        }
        reverse(nums, i, nums.length - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
