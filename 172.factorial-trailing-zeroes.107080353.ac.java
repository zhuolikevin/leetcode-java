/*
 * [172] Factorial Trailing Zeroes
 *
 * https://leetcode.com/problems/factorial-trailing-zeroes
 *
 * Easy (35.75%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
