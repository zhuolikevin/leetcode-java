/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings
 *
 * Easy (41.25%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"\n"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.equals("")) { return num2; }
        if (num2.equals("")) { return num1; }
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = carry + n1 + n2;
            int n = sum % 10;
            carry = sum / 10;
            sb.append(String.valueOf(n));
            i--;
            j--;
        }
        if (carry > 0) { sb.append(String.valueOf(carry)); }
        
        return sb.reverse().toString();
    }
}
