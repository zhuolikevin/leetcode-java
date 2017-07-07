/*
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers
 *
 * Easy (51.25%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        
        return a;
    }
}
