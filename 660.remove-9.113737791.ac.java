/*
 * [660] Remove 9
 *
 * https://leetcode.com/problems/remove-9
 *
 * Hard (43.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '10'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int newInteger(int n) {
        int res = 0;
        int base = 1;
        while (n > 0) {
            res += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        return res;
    }
}
