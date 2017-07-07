/*
 * [561] Array Partition I
 *
 * https://leetcode.com/problems/array-partition-i
 *
 * Easy (68.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,4,3,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
