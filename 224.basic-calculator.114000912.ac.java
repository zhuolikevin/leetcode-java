/*
 * [224] Basic Calculator
 *
 * https://leetcode.com/problems/basic-calculator
 *
 * Hard (26.80%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res = res + sign * sum;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
        }
        
        return res;
    }
}
