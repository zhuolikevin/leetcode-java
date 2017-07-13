/*
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring
 *
 * Medium (25.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"babad"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private String candidate;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        candidate = s.substring(s.length() - 1);
        
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        
        return candidate;
    }
    
    public void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > candidate.length()) {
            candidate = s.substring(left + 1, right);
        }
    }
}
