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
        if (s == null || s.length() == 0) {
            return sb.toString();
        }
        
        int left = getLeftIndex(s);
        int right = getRightIndex(s);
        if (left > right) {
            return sb.toString();
        }
        
        char[] chars = s.substring(left, right + 1).toCharArray();
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
    
    private int getLeftIndex(String s) {
        int left = 0;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        return left;
    }
    
    private int getRightIndex(String s) {
        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }
        return right;
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
