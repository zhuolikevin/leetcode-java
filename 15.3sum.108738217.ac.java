/*
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum
 *
 * Medium (21.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(res);
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                List<Integer> temp = new ArrayList<>();
                if (nums[left] + nums[right] == target) {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}
