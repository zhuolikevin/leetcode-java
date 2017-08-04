/*
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits
 *
 * Medium (26.20%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1432219"\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        if (stack.isEmpty()) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        
        int i = 0; 
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        return i == res.length() ? "0" : res.substring(i);
    }
}
