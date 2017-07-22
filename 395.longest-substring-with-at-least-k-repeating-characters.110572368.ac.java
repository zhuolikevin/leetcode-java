/*
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters
 *
 * Medium (35.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aaabb"\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return helper(s, 0, s.length() - 1, k);
    }
    
    private int helper(String s, int start, int end, int k) {
        if (start > end) {
            return 0;
        }
        if (end - start + 1 < k) {
            return 0;
        }
        
        int[] lib = new int[26];
        for (int i = start; i <= end; i++) {
            lib[s.charAt(i) - 'a']++;
        }
        
        for (int i = start; i <= end; i++) {
            if (lib[s.charAt(i) - 'a'] < k && lib[s.charAt(i) - 'a'] > 0) {
                return Math.max(helper(s, start, i - 1, k), helper(s, i + 1, end, k));
            }
        }
        
        return end - start + 1;
    }
}
