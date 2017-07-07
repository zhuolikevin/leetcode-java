/*
 * [283] Move Zeroes
 *
 * https://leetcode.com/problems/move-zeroes
 *
 * Easy (49.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
