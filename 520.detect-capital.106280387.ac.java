/*
 * [520] Detect Capital
 *
 * https://leetcode.com/problems/detect-capital
 *
 * Easy (52.14%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"USA"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        for (char c : chars) if (isCapital(c)) count++;
        return count == 0 || count == chars.length || (count == 1 && isCapital(chars[0]));
    }
    
    private boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
