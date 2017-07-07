/*
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break
 *
 * Medium (29.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                }
            }
        }
        
        return canBreak[s.length()];
    }
}
