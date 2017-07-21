/*
 * [306] Additive Number
 *
 * https://leetcode.com/problems/additive-number
 *
 * Medium (27.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"112358"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') {
                return false;
            }
            for (int j = 1; Math.max(i, j) <= num.length() - i - j; j++) {
                if (j > 1 && num.charAt(i) == '0') {
                    break;
                }
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(String num, int i, int j) {
        Long num1 = Long.parseLong(num.substring(0, i));
        Long num2 = Long.parseLong(num.substring(i, i + j));
        int start = 0;
        while (start + i + j != num.length()) {
            Long sum = num1 + num2;
            if (!num.startsWith(String.valueOf(sum), start + i + j)) {
                return false;
            }
            num1 = num2;
            num2 = sum;
            start += i;
            i = j;
            j = String.valueOf(sum).length();
        }
        return true;
    }
}


