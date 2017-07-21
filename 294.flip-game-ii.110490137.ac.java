/*
 * [294] Flip Game II
 *
 * https://leetcode.com/problems/flip-game-ii
 *
 * Medium (46.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"++++"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canWin(String s) {
        char[] chars = s.toCharArray();
        return helper(chars);
    }
    
    private boolean helper(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = '-';
                chars[i + 1] = '-';
                boolean canWin = !helper(chars);
                chars[i] = '+';
                chars[i + 1] = '+';
                if (canWin) {
                    return true;
                }
            }
        }
        return false;
    }
}
