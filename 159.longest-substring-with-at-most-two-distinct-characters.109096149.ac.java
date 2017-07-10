/*
 * [159] Longest Substring with At Most Two Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters
 *
 * Hard (40.86%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"eceba"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right)) || map.size() < 2) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                while (map.size() == 2) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    if (map.get(s.charAt(left)) == 0) {
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
            }
        }
        
        return maxLen;
    }
}
