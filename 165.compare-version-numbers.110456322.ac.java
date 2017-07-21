/*
 * [165] Compare Version Numbers
 *
 * https://leetcode.com/problems/compare-version-numbers
 *
 * Medium (19.97%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1"\n"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }
}
