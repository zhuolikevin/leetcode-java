/*
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses
 *
 * Hard (35.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"()())()"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(res, s, 0, 0, new char[] { '(', ')' });
        return res;
    }
    
    private void remove(List<String> res, String s, int lastI, int lastJ, char[] pair) {
        int stack = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                stack++;
            }
            if (s.charAt(i) == pair[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])) {
                    remove(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            remove(res, reversed, 0, 0, new char[] { ')', '(' });
        } else {
            res.add(reversed);
        }
    }
}
