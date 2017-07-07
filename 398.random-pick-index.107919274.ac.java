/*
 * [398] Random Pick Index
 *
 * https://leetcode.com/problems/random-pick-index
 *
 * Medium (42.20%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Solution","pick"]\n[[[1,2,3,3,3]],[3]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random rand = new Random();
        int res = -1;
        int count = 0;
       	for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) { continue; }
            if (rand.nextInt(count + 1) == count) {
                res = i;
            }
            count++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
