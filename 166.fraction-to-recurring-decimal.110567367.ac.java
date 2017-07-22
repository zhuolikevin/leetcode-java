/*
 * [166] Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 *
 * Medium (17.41%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
            sb.append("-");
        }
        
        long numeratorl = Math.abs((long)numerator);
        long denominatorl = Math.abs((long)denominator);
        
        long decimal = numeratorl / denominatorl;
        sb.append(decimal);
        long remain = numeratorl % denominatorl;
        if (remain == 0) {
            return sb.toString();
        }
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0 && !map.containsKey(remain)) {
            map.put(remain, sb.length());
            remain = remain * 10;
            long digit = remain / denominatorl;
            remain = remain % denominatorl;
            sb.append(digit);
        }
        
        String res = sb.toString();
        if (remain == 0) {
            return res;
        } else {
            return res.substring(0, map.get(remain)) + "(" + res.substring(map.get(remain)) + ")";
        }
    }
}
