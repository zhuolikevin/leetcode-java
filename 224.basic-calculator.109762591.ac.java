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
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int sum = chars[i] - '0';
                while (i < chars.length - 1 && Character.isDigit(chars[i + 1])) {
                    sum = sum * 10 + chars[i + 1] - '0';
                    i++;
                }
                result += sum * sign;
            } else if (chars[i] == '+') {
                sign = 1;
            } else if (chars[i] == '-') {
                sign = -1;
            } else if (chars[i] == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (chars[i] == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        
        return result;
    }
}
