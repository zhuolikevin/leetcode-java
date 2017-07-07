/*
 * [462] Minimum Moves to Equal Array Elements II
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii
 *
 * Medium (51.42%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mean = nums[nums.length / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - mean);
        }
        return res;
    }
}
