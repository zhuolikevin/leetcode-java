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
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        
        int count = 0;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dict.put(t.charAt(i), dict.getOrDefault(t.charAt(i), 0) + 1);
            count++;
        }
        
        int left = 0;
        int right = 0;
        int shortest = Integer.MAX_VALUE;
        String candidate = "";
        while (left < s.length()) {
            while (right < s.length() && count > 0) {
                char rightC = s.charAt(right);
                if (dict.containsKey(rightC)) {
                    dict.put(rightC, dict.get(rightC) - 1);
                    if (dict.get(rightC) >= 0) {
                        count--;
                    }
                }
                
                right++;
            }
            
            if (count == 0) {
                if (right - left < shortest) {
                    shortest = right - left;
                    candidate = s.substring(left, right);
                }
            }
            
            char leftC = s.charAt(left);
            if (dict.containsKey(leftC)) {
                dict.put(leftC, dict.get(leftC) + 1);
                if (dict.get(leftC) > 0) {
                    count++;
                }
            }
            left++;
        }
        
        return candidate;
    }
}
