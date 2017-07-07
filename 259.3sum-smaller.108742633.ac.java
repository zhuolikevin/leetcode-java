/*
 * [259] 3Sum Smaller
 *
 * https://leetcode.com/problems/3sum-smaller
 *
 * Medium (41.25%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}
