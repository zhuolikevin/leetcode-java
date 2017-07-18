/*
 * [280] Wiggle Sort
 *
 * https://leetcode.com/problems/wiggle-sort
 *
 * Medium (56.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,5,2,1,6,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 2; i < nums.length; i += 2) {
            if (nums[i] > nums[i - 1]) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
