/*
 * [360] Sort Transformed Array
 *
 * https://leetcode.com/problems/sort-transformed-array
 *
 * Medium (43.97%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[-4,-2,2,4]\n1\n3\n5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i < res.length) {
            int leftVal = a * nums[left] * nums[left] + b * nums[left] + c;
            int rightVal = a * nums[right] * nums[right] + b * nums[right] + c;
            if (leftVal < rightVal) {
                if (a > 0) {
                    res[res.length - i - 1] = rightVal;
                    right--;
                } else {
                    res[i] = leftVal;
                    left++;
                }
            } else {
                if (a > 0) {
                    res[res.length - i - 1] = leftVal;
                    left++;
                } else {
                    res[i] = rightVal;
                    right--;
                }
            }
            i++;
        }
        
        return res;
    }
}
