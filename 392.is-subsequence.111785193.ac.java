/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence
 *
 * Medium (44.33%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
