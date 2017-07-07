/*
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest
 *
 * Medium (30.96%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,0,0]\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return target;
        }
        
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        int candidate = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    candidate = sum;
                }
            }
        }
        
        return candidate;
    }
}
