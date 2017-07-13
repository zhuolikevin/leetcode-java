/*
 * [340] Longest Substring with At Most K Distinct Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 *
 * Hard (38.52%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"eceba"\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (left < s.length()) {
            while (right < s.length() && (map.size() < k || map.size() == k && map.containsKey(s.charAt(right)))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left);
            map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
            if (map.get(s.charAt(left)) == 0) {
                map.remove(s.charAt(left));
            }
            left++;
        }
        
        return maxLen;
    }
}
