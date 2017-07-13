/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 *
 * Medium (24.21%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abcabcbb"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (left < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left);
            set.remove(s.charAt(left));
            left++;
        }
        
        return maxLen;
    }
}
