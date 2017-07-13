/*
 * [152] Maximum Product Subarray
 *
 * https://leetcode.com/problems/maximum-product-subarray
 *
 * Medium (25.45%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[-2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int lastMaxProd = nums[0];
        int lastMinProd = nums[0];
        int maxProd = lastMaxProd;
        for (int i = 1; i < nums.length; i++) {
            int newMaxProd = Math.max(nums[i], Math.max(nums[i] * lastMaxProd, nums[i] * lastMinProd));
            int newMinProd = Math.min(nums[i], Math.min(nums[i] * lastMaxProd, nums[i] * lastMinProd));
            maxProd = Math.max(maxProd, newMaxProd);
            lastMaxProd = newMaxProd;
            lastMinProd = newMinProd;
        }
        
        return maxProd;
    }
}
