/*
 * [482] License Key Formatting
 *
 * https://leetcode.com/problems/license-key-formatting
 *
 * Medium (41.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"2-4A0r7-4k"\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        S = S.toUpperCase();
        int i = S.length() - 1;
        int count = 0;
        while (i >= 0) {
            if (S.charAt(i) != '-') {
                count = (count + 1) % K;
                sb.append(S.charAt(i));
                if (count == 0) {
                    sb.append('-');
                }    
            }
            i--;
        }
        String res = sb.reverse().toString();
        i = 0;
        while (i < res.length() && res.charAt(i) == '-') {
            i++;
        }
        return res.substring(i);
    }
}
