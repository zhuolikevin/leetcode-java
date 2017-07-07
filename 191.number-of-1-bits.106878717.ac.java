/*
 * [191] Number of 1 Bits
 *
 * https://leetcode.com/problems/number-of-1-bits
 *
 * Easy (39.37%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '           0 (00000000000000000000000000000000)'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
    	while (n != 0) {
    		count += (n & 1);
    		n >>>= 1;
    	}
    	return count;
    }
}
