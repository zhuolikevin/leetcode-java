/*
 * [556] Next Greater Element III
 *
 * https://leetcode.com/problems/next-greater-element-iii
 *
 * Medium (28.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '12'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 1;
        while (i >= 1 && chars[i - 1] >= chars[i]) {
            i--;
        }
        if (i == 0) {
            return -1;
        }
        
        char toReplace = chars[i - 1];
        int j = chars.length - 1;
        while (j >= i && chars[j] <= toReplace) {
            j--;
        }
        
        swap(chars, i - 1, j);
        reverse(chars, i, chars.length - 1);
        long res = Long.parseLong(new String(chars));
        return res > Integer.MAX_VALUE ? -1 : (int)res;
    }
    
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
