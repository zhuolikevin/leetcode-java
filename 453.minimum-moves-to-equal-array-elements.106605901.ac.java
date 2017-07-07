/*
 * [453] Minimum Moves to Equal Array Elements
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements
 *
 * Easy (47.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) min = Math.min(min, num);
        int res = 0;
        for (int num : nums) res += num - min;
        return res;
    }
}
