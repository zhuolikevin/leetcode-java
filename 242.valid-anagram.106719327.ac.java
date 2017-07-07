/*
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram
 *
 * Easy (46.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { return false; }
        char[] lib = new char[26];
        for (int i = 0; i < s.length(); i++) {
            lib[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (lib[t.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                lib[t.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}
