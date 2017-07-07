/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array
 *
 * Easy (24.37%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
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
