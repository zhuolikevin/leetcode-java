/*
 * [484] Find Permutation
 *
 * https://leetcode.com/problems/find-permutation
 *
 * Medium (53.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"DDIIDI"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        if (s == null || s.length() == 0) {
            return res;
        }
        
        res[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                res[i + 1] = i + 2;
            } else {
                res[i + 1] = res[i];
                int j = i;
                while (j >= 0 && s.charAt(j) == 'D') {
                    res[j]++;
                    j--;
                }
            }
        }
        
        return res;
    }
}
