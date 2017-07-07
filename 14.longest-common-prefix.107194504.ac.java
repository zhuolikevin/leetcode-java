/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix
 *
 * Easy (31.41%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) { return res; }
        
        int i = 0;
        boolean finished = false;
        while (i < strs[0].length() && !finished) {
            char curChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != curChar) {
                    finished = true;
                    break;
                }
            }
            if (!finished) {
                res += String.valueOf(curChar);
                i++;
            }
        }
        return res;
    }
}
