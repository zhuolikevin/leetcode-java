/*
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii
 *
 * Hard (23.01%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private Set<String> set = new HashSet<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        
        for (String word : wordDict) {
            set.add(word);
        }
        
        List<String> res = new ArrayList<>();
        if (!isBreakable(s)) {
            return res;
        }
        
        helper(res, s, 0, "");
        
        return res;
    }
    
    private boolean isBreakable(String s) {
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
    
    private void helper(List<String> res, String s, int start, String path) {
        if (start == s.length()) {
            res.add(path.trim());
            return;
        }
        
        for (int len = 1; start + len - 1 < s.length(); len++) {
            String subStr = s.substring(start, start + len);
            if (set.contains(subStr)) {
                helper(res, s, start + len, path + subStr + " ");
            }
        }
    }
}
