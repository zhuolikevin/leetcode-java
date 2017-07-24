/*
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number
 *
 * Hard (12.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"3"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterESeen = true;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numberSeen = true;
                numberAfterESeen = true;
            } else if (s.charAt(i) == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterESeen = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterESeen;
    }
}
