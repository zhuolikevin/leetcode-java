/*
 * [504] Base 7
 *
 * https://leetcode.com/problems/base-7
 *
 * Easy (44.80%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '100'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) { return "0"; }
        if (num < 0) { return new StringBuilder("-" + convertToBase7(-num)).toString(); }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int remain = num % 7;
            num = num / 7;
            sb.append(String.valueOf(remain));
        }
        return sb.reverse().toString();
    }
}
