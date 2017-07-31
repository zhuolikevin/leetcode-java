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
        if (strs.length == 0) {
            return res;
        }
        
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char cur = strs[0].charAt(i);
            boolean common = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != cur) {
                    common = false;
                    break;
                }
            }
            if (common) {
                sb.append(cur);
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}
