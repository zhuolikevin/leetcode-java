/*
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses
 *
 * Easy (33.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"["'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) { return false; }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) { return false; }
                char last = stack.pop();
                switch (s.charAt(i)) {
                    case ')':
                        if (last != '(') { return false; }
                        break;
                    case ']':
                        if (last != '[') { return false; }
                        break;
                    case '}':
                        if (last != '{') { return false; }
                        break;  
                }
            }
        }
        return stack.isEmpty();
    }
}
