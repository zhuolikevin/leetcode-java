/*
 * [581] Shortest Unsorted Continuous Subarray
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray
 *
 * Easy (30.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1;
        boolean canAdd = true;
        for (int i = 0; i < nums.length; i++) {
          if (canAdd && (left == -1 || nums[i] >= nums[left])) { left++; }
          else {
            canAdd = false;
            while (left != -1 && nums[left] > nums[i]) { left--; }
            if (left == -1) { break; }
          }
        }
        int right = nums.length;
        boolean canMinus = true;
        for (int i = nums.length - 1; i >= 0; i--) {
          if (canMinus && (right == nums.length || nums[i] <= nums[right])) { right--; }
          else {
            canMinus = false;
            while (right != nums.length && nums[right] < nums[i]) { right++; }
            if (right == nums.length) { break; }
          }
        }
        return left < right ? right - left - 1 : 0;
    }
}
