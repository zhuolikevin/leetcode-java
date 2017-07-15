/*
 * [150] Evaluate Reverse Polish Notation
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 *
 * Medium (26.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["18"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        String[] ops = { "+", "-", "*", "/" };
        Set<String> set = new HashSet<>(Arrays.asList(ops));
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (set.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.peek();
    }
}
