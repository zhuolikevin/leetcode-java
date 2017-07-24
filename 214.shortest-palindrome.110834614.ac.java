/*
 * [214] Shortest Palindrome
 *
 * https://leetcode.com/problems/shortest-palindrome
 *
 * Hard (24.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aacecaaa"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int longest;
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        longest = 1;
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        
        StringBuilder sb = new StringBuilder(s.substring(longest));
        return sb.reverse().toString() + s;
    }
    
    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (left == -1) {
            longest = Math.max(longest, right);
        }
    }
}
