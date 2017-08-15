/*
 * [461] Hamming Distance
 *
 * https://leetcode.com/problems/hamming-distance
 *
 * Easy (70.33%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {
                count += 1;
            }
            x >>>= 1;
            y >>>= 1;
        }
        return count;
    }
}
