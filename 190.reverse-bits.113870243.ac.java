/*
 * [190] Reverse Bits
 *
 * https://leetcode.com/problems/reverse-bits
 *
 * Easy (29.52%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '           0 (00000000000000000000000000000000)'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1);
            n >>>= 1;
            if (i < 31) {
                res <<= 1;
            }
        }
        
        return res;
    }
}
