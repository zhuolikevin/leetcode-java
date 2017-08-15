/*
 * [522] Longest Uncommon Subsequence II
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii
 *
 * Medium (30.88%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["aba","cdc","eae"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        for (int i = 0; i < strs.length; i++) {
            boolean find = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                
                if (isSubsequence(strs[i], strs[j])) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return strs[i].length();
            }
        }
        return -1;
    }
    
    private boolean isSubsequence(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            while (j < s2.length() && s1.charAt(i) != s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
