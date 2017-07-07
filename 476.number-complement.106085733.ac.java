/*
 * [476] Number Complement
 *
 * https://leetcode.com/problems/number-complement
 *
 * Easy (61.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findComplement(int num) {
        int bit = 0;
        int result = 0;
        while (num > 0) {
            result += (1 - num % 2) << bit;
            bit += 1;
            num >>= 1;
        }
        return result;
    }
}
