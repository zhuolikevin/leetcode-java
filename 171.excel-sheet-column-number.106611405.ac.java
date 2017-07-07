/*
 * [171] Excel Sheet Column Number
 *
 * https://leetcode.com/problems/excel-sheet-column-number
 *
 * Easy (46.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"A"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res += (chars[chars.length - i - 1] - 'A' + 1) * Math.pow(26, i);
        }
        return res;
    }
}
