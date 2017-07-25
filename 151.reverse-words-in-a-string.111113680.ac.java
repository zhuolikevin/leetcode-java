/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string
 *
 * Medium (15.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        if (s == null || s.length() == 0) {
            return sb.toString();
        }
        
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        swap(chars, 0, chars.length - 1);
        
        int start = 0;
        int end = 0;
        while (end < chars.length) {
            if (chars[end] != ' ') {
                end++;
                continue;
            }
            
            for (int i = end - 1; i >= start; i--) {
                sb.append(chars[i]);
            }
            sb.append(' ');
            while (chars[end] == ' ') {
                end++;
            }
            start = end;
        }
        for (int i = end - 1; i >= start; i--) {
            sb.append(chars[i]);
        }
        
        return sb.toString();
    }
    
    private void swap(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
