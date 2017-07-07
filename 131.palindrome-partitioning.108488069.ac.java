/*
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning
 *
 * Medium (32.70%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private boolean[][] isPalin;
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        isPalin = isPalin(s);
        
        return helper(s, 0);
    }
    
    private List<List<String>> helper(String s, int start) {
        List<List<String>> res = new ArrayList<>();
        if (start == s.length()) {
            return res;
        }
        for (int len = 1; start + len - 1 < s.length(); len++) {
            if (isPalin[start][start + len - 1]) {
                if (start + len == s.length()) {
                    List<String> temp = new ArrayList<>();
                    temp.add(s.substring(start, start + len));
                    res.add(temp);
                } else {
                    List<List<String>> remains = helper(s, start + len);
                    for (List<String> remain : remains) {
                        remain.add(0, s.substring(start, start + len));
                        res.add(remain);
                    }
                }
            }
        }
        return res;
    }
    
    private boolean[][] isPalin(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = true;
            if (i < s.length() - 1) {
                res[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }
        
        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                res[start][start + len] = res[start + 1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }
        
        return res;
    }
}
