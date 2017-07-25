/*
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii
 *
 * Medium (29.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int calculate(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
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
                numStack.push(sum);
                if (!opStack.isEmpty() && (opStack.peek() == '*' || opStack.peek() == '/')) {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    char op = opStack.pop();
                    numStack.push(op == '*' ? num1 * num2 : num1 / num2);
                }
            } else if (c == '+' || c == '-') {
                if (!opStack.isEmpty()) {
                    int num2 = numStack.pop();
                    int num1 = numStack.pop();
                    char op = opStack.pop();
                    numStack.push(op == '+' ? num1 + num2 : num1 - num2);
                }
                opStack.push(c);
            } else {
                opStack.push(c);
            }
        }
        
        while (!opStack.isEmpty()) {
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            char op = opStack.pop();
            numStack.push(op == '+' ? num1 + num2 : num1 - num2);
        }
        
        return numStack.peek();
    }
}
