/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string
 *
 * Medium (41.11%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sum = sum * 10 + chars[i] - '0';
            } else if (chars[i] == '[') {
                countStack.push(sum);
                sum = 0;
                strStack.push(sb.toString());
                sb.setLength(0);
            } else if (chars[i] == ']') {
                String repeated = sb.toString();
                sb.setLength(0);
                sb.append(strStack.pop());
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    sb.append(repeated);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        
        return sb.toString();
    }
}
