/*
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome
 *
 * Easy (45.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abccccdd"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0) { return 0; }
        int[] lib = new int[52];
        for (int i = 0; i < s.length(); i++) {
            lib[getLibIndex(s.charAt(i))]++;
        }
        boolean oddFlag = false;
        int res = 0;
        for (int i = 0; i < 52; i++) {
            if (lib[i] % 2 == 0) {
                res += lib[i];
            } else {
                oddFlag = true;
                res += lib[i] - 1;
            }
        }
        return oddFlag ? res + 1 : res;
    }
    
    private int getLibIndex(char c) {
        return c >= 'a' && c <= 'z' ? c - 'a' : c - 'A' + 26;
    }
}
