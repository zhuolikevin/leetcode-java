/*
 * [521] Longest Uncommon Subsequence I 
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-i
 *
 * Easy (54.62%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aba"\n"cdc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()) {
            return a.equals(b) ? -1 : a.length();
        } else {
            return a.length() > b.length() ? a.length() : b.length();
        }
    }
}
