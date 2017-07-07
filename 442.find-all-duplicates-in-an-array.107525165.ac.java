/*
 * [442] Find All Duplicates in an Array
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 *
 * Medium (54.91%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) { continue; }
            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    set.add(nums[i]);
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        return new ArrayList<Integer>(set);
    }
}
