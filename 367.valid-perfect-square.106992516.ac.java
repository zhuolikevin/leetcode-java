/*
 * [367] Valid Perfect Square
 *
 * https://leetcode.com/problems/valid-perfect-square
 *
 * Easy (38.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '16'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) { return false; }
        if (num == 0 || num == 1) { return true; }
        int i = 1;
        while (i <= num / 2) {
            if (i * i == num) { return true; }
            i++;
        }
        return false;
    }
}
