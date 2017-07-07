/*
 * [132] Palindrome Partitioning II
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii
 *
 * Hard (24.00%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        boolean[][] isPalin = getPalin(s);
        
        int[] minCuts = new int[s.length() + 1];
        minCuts[0] = -1;
        for (int i = 1; i <= s.length(); i++) {
            int curMinCut = s.length();
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1]) {
                    curMinCut = Math.min(curMinCut, minCuts[j] + 1);
                }
            }
            minCuts[i] = curMinCut;
        }
        
        return minCuts[s.length()];
    }
    
    private boolean[][] getPalin(String s) {
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
