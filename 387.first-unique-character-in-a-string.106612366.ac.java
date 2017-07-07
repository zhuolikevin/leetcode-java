/*
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string
 *
 * Easy (46.39%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"leetcode"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int firstUniqChar(String s) {
        int[] lib = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lib[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (lib[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
