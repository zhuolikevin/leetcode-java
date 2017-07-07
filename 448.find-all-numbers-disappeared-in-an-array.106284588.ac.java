/*
 * [448] Find All Numbers Disappeared in an Array
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 *
 * Easy (51.92%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if (nums.length == 0) return result;
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = - Math.abs(nums[index]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i+1);
        }
        return result;
    }
}
