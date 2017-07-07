/*
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern
 *
 * Easy (38.20%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) { return false; }
        int strLen = s.length();
        for (int length = 1; length <= strLen / 2; length++) {
            if (strLen % length != 0) { continue; }
            String unit = s.substring(0, length);
            boolean find = true;
            for (int i = length; i < strLen; i += length) {
                if (!s.substring(i, i + length).equals(unit)) {
                    find = false;
                    break;
                }
            }
            if (find) { return true; }
        }
        return false;
    }
}
