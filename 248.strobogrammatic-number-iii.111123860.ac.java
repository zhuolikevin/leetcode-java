/*
 * [248] Strobogrammatic Number III
 *
 * https://leetcode.com/problems/strobogrammatic-number-iii
 *
 * Hard (31.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"\n"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count;
    
    public int strobogrammaticInRange(String low, String high) {
        this.count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            char[] chars = new char[len];
            dfs(low, high, chars, 0, len - 1);
        }
        
        return this.count;
    }
    
    private void dfs(String low, String high, char[] chars, int left, int right) {
        if (left > right) {
            String num = new String(chars);
            if (num.length() == low.length() && num.compareTo(low) < 0 ||
               num.length() == high.length() && num.compareTo(high) > 0) {
                return;
            }
            this.count++;
            return;
        }
        
        for (char[] pair : pairs) {
            chars[left] = pair[0];
            chars[right] = pair[1];
            if (chars.length != 1 && chars[0] == '0') {
                continue;
            }
            if (left == right && pair[0] != pair[1]) {
                continue;
            }
            dfs(low, high, chars, left + 1, right - 1);
        }
    }
}
