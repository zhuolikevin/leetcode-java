/*
 * [268] Missing Number
 *
 * https://leetcode.com/problems/missing-number
 *
 * Easy (44.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (nums[i] != i) {
                if (nums[i] == -1) { break; }
                if (nums[i] == nums.length) {
                    nums[i] = -1;
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == -1) { return i; }
        }
        return nums.length;
    }
}
