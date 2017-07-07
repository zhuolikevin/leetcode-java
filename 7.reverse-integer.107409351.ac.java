/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer
 *
 * Easy (24.27%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int reverse(int x) {
        if (x == 0) { return 0; }
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }
        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            if (isNegative && 2147483647 - res >= digit - 1) {
                res += digit;
            } else if (!isNegative && digit <= 2147483647 - res) {
                res += digit;
            } else {
                return 0;
            }
            if (res <= 214748364 && x != 0) {
                res = res * 10;
            } else if (res > 214748364 && x != 0) {
                return 0;
            }
        }
        
        return isNegative ? -res : res;
    }
}
