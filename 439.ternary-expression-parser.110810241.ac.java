/*
 * [439] Ternary Expression Parser
 *
 * https://leetcode.com/problems/ternary-expression-parser
 *
 * Medium (50.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"T?2:3"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (stack.isEmpty() || stack.peek() != '?') {
                stack.push(c);
            } else {
                stack.pop();
                char trueClause = stack.pop();
                stack.pop();
                char falseClause = stack.pop();
                char clause = c == 'T' ? trueClause : falseClause;
                stack.push(clause);
            }
        }
        
        return String.valueOf(stack.peek());
    }
}
