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
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
        }
        
        return maxLen;
    }
}
