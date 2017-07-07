/*
 * [290] Word Pattern
 *
 * https://leetcode.com/problems/word-pattern
 *
 * Easy (32.87%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str.length() == 0 && pattern.length() != 0 || str.length() != 0 && pattern.length() == 0) { return false; }
        if (str.length() == 0 && pattern.length() == 0) { return true; }
        
        String[] words = str.split(" ");
        if (pattern.length() != words.length) { return false; }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char curChar = pattern.charAt(i);
            if (!map.containsKey(curChar)) {
                map.put(curChar, words[i]);
            } else if (!map.get(curChar).equals(words[i])) {
                return false;
            }
        }
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map2.containsKey(words[i])) {
                map2.put(words[i], pattern.charAt(i));
            } else if (!map2.get(words[i]).equals(pattern.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
