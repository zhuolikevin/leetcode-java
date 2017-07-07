/*
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one
 *
 * Easy (38.31%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + 1;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) { break; }
        }
        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = carry;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }
    }
}
