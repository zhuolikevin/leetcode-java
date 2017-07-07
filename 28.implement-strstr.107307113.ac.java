/*
 * [28] Implement strStr()
 *
 * https://leetcode.com/problems/implement-strstr
 *
 * Easy (27.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen < nLen) { return -1; }
        if (nLen == 0) { return 0; }
        
        for (int i = 0; i < hLen - nLen + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while (j < nLen) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) { break; }
                    j++;
                }
                if (j == nLen) { return i; }
            }
        }
        return -1;
    }
}
