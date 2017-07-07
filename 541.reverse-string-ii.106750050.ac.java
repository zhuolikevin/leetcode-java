/*
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii
 *
 * Easy (43.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abcdefg"\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars.length - i >= k) {
                // We can reverse k chars
                reverse(chars, i, i + k - 1);
                i += k;
                if (chars.length - i >= k) {
                    i += k;
                } else {
                    break;
                }
            } else {
                reverse(chars, i, chars.length - 1);
                break;
            }
        }
        return new String(chars);
    }
    
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
