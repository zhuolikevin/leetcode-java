/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string
 *
 * Easy (58.87%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"hello"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        
        return new String(chars);
    }
}
