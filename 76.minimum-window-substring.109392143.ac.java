/*
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring
 *
 * Hard (25.01%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"a"\n"a"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (t == null || s == null || t.length() > s.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        String candidate = null;
        int count = t.length();
        int left = 0;
        int right = 0;
        
        while (left < s.length()) {
            while (right < s.length() && count != 0) {
                if (map.containsKey(s.charAt(right))) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    if (map.get(s.charAt(right)) >= 0) {
                        count--;    
                    }
                }
                right++;
            }
            
            if (count == 0) {
                if (candidate == null || right - left < candidate.length()) {
                    candidate = s.substring(left, right);
                }
            }
            
            if (map.containsKey(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if (map.get(s.charAt(left)) > 0) {
                    count++; 
                }
            }
            left++;
        }
        
        return candidate == null ? "" : candidate;
    }
}
