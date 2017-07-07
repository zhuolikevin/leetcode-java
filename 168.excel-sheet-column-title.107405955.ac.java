/*
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title
 *
 * Easy (25.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String convertToTitle(int n) {
        String[] lib = new String[]{
            "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X",
            "Y", "Z"
        };
        
        if (n < 1) { return ""; }
        String res = "";
        while (n > 0) {
            int remain = (n - 1) % 26;
            n = (n - 1) / 26;
            res = lib[remain] + res;
        }
        return res;
    }
}
