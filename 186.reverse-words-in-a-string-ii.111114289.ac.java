/*
 * [186] Reverse Words in a String II
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-ii
 *
 * Medium (27.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        int right = 0;
        while (right < s.length) {
            if (s[right] == ' ') {
                reverse(s, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        reverse(s, left, right - 1);
    }
    
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
