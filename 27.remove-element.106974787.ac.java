/*
 * [27] Remove Element
 *
 * https://leetcode.com/problems/remove-element
 *
 * Easy (38.63%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
      if (nums.length == 0) { return 0; }
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
          if (nums[left] == val) {
              int temp = nums[left];
              nums[left] = nums[right];
              nums[right] = temp;
              right--;
          } else {
              left++;
          }
      }
      return left;
    }
}
