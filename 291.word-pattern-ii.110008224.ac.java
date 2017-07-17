/*
 * [291] Word Pattern II
 *
 * https://leetcode.com/problems/word-pattern-ii
 *
 * Hard (37.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abab"\n"redblueredblue"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return search(str, 0, pattern, 0, map, set);
    }
    
    private boolean search(String str, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        } else if (i == str.length() || j == pattern.length()) {
            return false;
        }
        
        char curChar = pattern.charAt(j);
        
        if (map.containsKey(curChar)) {
            String requiredStr = map.get(curChar);
            
            if (!str.startsWith(requiredStr, i)) {
                return false;
            }
            
            return search(str, i + requiredStr.length(), pattern, j + 1, map, set);
        }
        
        for (int k = i; k < str.length(); k++) {
            String newStr = str.substring(i, k + 1);
            
            if (set.contains(newStr)) {
                continue;
            }
            
            map.put(curChar, newStr);
            set.add(newStr);
            
            if (search(str, k + 1, pattern, j + 1, map, set)) {
                return true;
            }
            
            map.remove(curChar);
            set.remove(newStr);
        }
        
        return false;
    }
}
