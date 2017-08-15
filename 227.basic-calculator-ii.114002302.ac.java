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
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
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
                if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    int num = nums.pop();
                    char op = ops.pop();
                    sum = op == '*' ? num * sum : num / sum;
                }
                nums.push(sum);
            } else if (c == '*' || c == '/') {
                ops.push(c);
            } else if (c == '+' || c == '-') {
                if (!ops.isEmpty()) {
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    char op = ops.pop();
                    int num = op == '+' ? num1 + num2 : num1 - num2;
                    nums.push(num);
                }
                ops.push(c);
            }
        }
        
        if (!ops.isEmpty()) {
            int num2 = nums.pop();
            int num1 = nums.pop();
            char op = ops.pop();
            int num = op == '+' ? num1 + num2 : num1 - num2;
            nums.push(num);
        }
        
        return nums.peek();
    }
}
