/*
 * [18] 4Sum
 *
 * https://leetcode.com/problems/4sum
 *
 * Medium (26.52%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int subTarget = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    List<Integer> temp = new ArrayList<>();
                    if (nums[left] + nums[right] == subTarget) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > subTarget) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        
        return res;
    }
}
