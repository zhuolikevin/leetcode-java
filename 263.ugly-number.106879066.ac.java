/*
 * [263] Ugly Number
 *
 * https://leetcode.com/problems/ugly-number
 *
 * Easy (39.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '-2147483648'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isUgly(int num) {
        if (num < 1) { return false; }
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
