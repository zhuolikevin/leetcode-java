/*
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii
 *
 * Easy (59.81%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j <= chars.length) {
            if (j == chars.length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        return new String(chars);
    }
    
    private void reverse(char[] word, int left, int right) {
        char temp;
        while (left < right) {
            temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }
    }
}
