/*
 * [455] Assign Cookies
 *
 * https://leetcode.com/problems/assign-cookies
 *
 * Easy (47.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            while (sIndex < s.length && s[sIndex] < g[i]) {
                sIndex++;
            }
            if (sIndex == s.length) break;
            count++;
            sIndex++;
        }
        return count;
    }
}
