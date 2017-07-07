/*
 * [405] Convert a Number to Hexadecimal
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal
 *
 * Easy (41.01%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '26'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String toHex(int num) {
        if (num == 0) { return "0"; }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int remain = num & 0xf;
            num = num >>> 4;
            if (remain > 9) {
                switch (remain) {
                    case 10:
                        sb.append("a");
                        break;
                    case 11:
                        sb.append("b");
                        break;
                    case 12:
                        sb.append("c");
                        break;
                    case 13:
                        sb.append("d");
                        break;
                    case 14:
                        sb.append("e");
                        break;
                    case 15:
                        sb.append("f");
                        break;
                }
            } else {
                sb.append(String.valueOf(remain));
            }
        }
        return sb.reverse().toString();
    }
}
