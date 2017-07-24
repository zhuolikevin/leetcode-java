/*
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain
 *
 * Medium (42.96%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                return p[1] - q[1];
            }
        });
        
        int count = 0;
        Integer end = null;
        for (int i = 0; i < pairs.length; i++) {
            if (end == null || pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }
        
        return count;
    }
}
