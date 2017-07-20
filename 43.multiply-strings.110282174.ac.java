/*
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings
 *
 * Medium (26.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"\n"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String multiply(String num1, String num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);
        int l1 = num1.length();
        int l2 = num2.length();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l2; i++) {
            int carry = 0;
            for (int j = 0; j < l1; j++) {
                int former = i + j < sb.length() ? sb.charAt(i + j) - '0' : 0;
                int prod = (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry + former;
                int remain = prod % 10;
                carry = prod / 10;
                if (i + j < sb.length()) {
                    sb.setCharAt(i + j, (char)(remain + '0'));
                } else {
                    sb.append(remain);
                }
            }
            if (carry > 0) {
                sb.append(carry);
            }
        }
        
        String res = sb.reverse().toString();
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        return i == res.length() ? "0" : res.substring(i);
    }
    
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }
}
