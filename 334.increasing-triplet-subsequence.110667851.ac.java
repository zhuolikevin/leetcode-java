/*
 * [334] Increasing Triplet Subsequence
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence
 *
 * Medium (39.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= big) {
                big = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
