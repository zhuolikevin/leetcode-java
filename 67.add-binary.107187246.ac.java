/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary
 *
 * Easy (32.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0"\n"0"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int n2 = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;
            int sum = n1 + n2 + carry;
            res = String.valueOf(sum % 2) + res;
            carry = sum / 2;
            i--;
            j--;
        }
        return carry > 0 ? "1" + res : res;
    }
}
