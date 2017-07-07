/*
 * [238] Product of Array Except Self
 *
 * https://leetcode.com/problems/product-of-array-except-self
 *
 * Medium (48.69%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) { return nums; }
        
        int[] output = new int[len];
        output[0] = nums[0];
        for (int i = 1; i < len; i++) {
            output[i] = output[i-1] * nums[i];
        }
        
        int curRightProd = 1;
        for (int i = len - 1; i > 0; i--) {
            int curLeftProd = output[i-1];
            output[i] = curLeftProd * curRightProd;
            curRightProd *= nums[i];
        }
        output[0] = curRightProd;
        return output;
    }
}
