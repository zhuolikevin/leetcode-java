/*
 * [611] Valid Triangle Number
 *
 * https://leetcode.com/problems/valid-triangle-number
 *
 * Medium (38.67%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,2,3,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
