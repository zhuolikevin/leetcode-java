/*
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome
 *
 * Easy (26.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPalindrome(String s) {
        String ss = s.toLowerCase();
        int left = 0;
        int right = ss.length() - 1;
        while (left < right) {
            while (left < ss.length() && !isAlphanumeric(ss.charAt(left))) { left++; }
            while (right >= 0 && !isAlphanumeric(ss.charAt(right))) { right--; }
            if (left >= right) { break; }
            
            if (ss.charAt(left) != ss.charAt(right)) { return false; }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }
}
