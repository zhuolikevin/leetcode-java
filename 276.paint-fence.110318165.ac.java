/*
 * [276] Paint Fence
 *
 * https://leetcode.com/problems/paint-fence
 *
 * Easy (34.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numWays(int n, int k) {
        if (n <= 0 || k < 1) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        long[] dp = new long[n];
        int same = k;
        int diff = k * (k - 1);
        for (int i = 3; i <= n; i++) {
            int newSame = diff;
            int newDiff = (diff + same) * (k - 1);
            same = newSame;
            diff = newDiff;
        }
        return same + diff;
    }
}
