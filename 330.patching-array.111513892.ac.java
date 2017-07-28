/*
 * [330] Patching Array
 *
 * https://leetcode.com/problems/patching-array
 *
 * Hard (31.92%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3]\n6'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long miss = 1;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patch++;
            }
        }
        
        return patch;
    }
}
