/*
 * [370] Range Addition
 *
 * https://leetcode.com/problems/range-addition
 *
 * Medium (55.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5\n[[1,3,2],[2,4,3],[0,2,-2]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0 || updates == null) {
            return new int[0];
        }
        if (updates.length == 0) {
            return new int[length];
        }
        
        int[] res = new int[length];
        for (int[] update : updates) {
            int left = update[0];
            int right = update[1];
            int inc = update[2];
            for (int i = left; i <= right; i++) {
                res[i] += inc;
            }
        }
        
        return res;
    }
}
