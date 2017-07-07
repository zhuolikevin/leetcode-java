/*
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits
 *
 * Medium (45.87%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return 10; }
        if (n > 10) { n = 10; }
        int count = 10;
        int i = 2;
        while (i <= n) {
            int prod = 9;
            for (int j = 1; j < i; j++) {
                prod = prod * (10 - j);
            }
            count += prod;
            i++;
        }
        return count;
    }
}
