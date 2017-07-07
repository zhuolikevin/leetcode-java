/*
 * [598] Range Addition II
 *
 * https://leetcode.com/problems/range-addition-ii
 *
 * Easy (48.38%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3\n3\n[[2,2],[3,3]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        for (int[] op : ops) {
            minM = Math.min(op[0], minM);
            minN = Math.min(op[1], minN);
        }
        return minM * minN;
    }
}
