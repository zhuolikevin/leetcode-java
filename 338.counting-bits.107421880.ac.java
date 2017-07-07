/*
 * [338] Counting Bits
 *
 * https://leetcode.com/problems/counting-bits
 *
 * Medium (60.96%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
