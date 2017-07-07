/*
 * [495] Teemo Attacking
 *
 * https://leetcode.com/problems/teemo-attacking
 *
 * Medium (51.69%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,4]\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        Integer end = null;
        for (int i = 0; i < timeSeries.length; i++) {
            if (end == null || timeSeries[i] > end) {
                res += duration;
            } else {
                res += timeSeries[i] + duration - 1 - end;
            }
            end = timeSeries[i] + duration - 1;
        }
        return res;
    }
}
