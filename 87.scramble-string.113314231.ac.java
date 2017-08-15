/*
 * [87] Scramble String
 *
 * https://leetcode.com/problems/scramble-string
 *
 * Hard (29.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"a"\n"a"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len == 1) {
            return s1.equals(s2);
        }
        
        int[] lib = new int[26];
        for (int i = 0; i < len; i++) {
            lib[s1.charAt(i) - 'a']++;
            lib[s2.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (lib[i] != 0) {
                return false;
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
               isScramble(s1.substring(i), s2.substring(i)) ||
               isScramble(s1.substring(0, i), s2.substring(len - i)) &&
               isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;
            }
        }
        return false;
    }
}
