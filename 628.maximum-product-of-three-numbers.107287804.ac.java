/*
 * [628] Maximum Product of Three Numbers
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers
 *
 * Easy (45.53%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maximumProduct(int[] nums) {
         Arrays.sort(nums);
         int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
         int b = nums[0] * nums[1] * nums[nums.length - 1];
         return a > b ? a : b;
    }
}
