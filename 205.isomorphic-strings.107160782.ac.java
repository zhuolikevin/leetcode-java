/*
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings
 *
 * Easy (33.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"egg"\n"add"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) { return false; }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if (!map.containsKey(curS)) {
                map.put(curS, curT);
            } else if (map.containsKey(curS) && map.get(curS) != curT) {
                return false;
            }
        }
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if (!map.containsKey(curT)) {
                map.put(curT, curS);
            } else if (map.containsKey(curT) && map.get(curT) != curS) {
                return false;
            }
        }
        return true;
    }
}
