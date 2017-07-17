/*
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi
 *
 * Medium (13.96%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) {
            return 0;
        }
        
        int sign = 1;
        if (str.charAt(index) == '+') {
            sign = 1;
            index += 1;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index += 1;
        }
        
        int num = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            if (sign == 1 && (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 8)) {
                return Integer.MIN_VALUE;
            } else {
                num = num * 10 + str.charAt(index) - '0';
            }
            index++;
        }
        
        return sign * num;
    }
}
