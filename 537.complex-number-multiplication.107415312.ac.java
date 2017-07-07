/*
 * [537] Complex Number Multiplication
 *
 * https://leetcode.com/problems/complex-number-multiplication
 *
 * Medium (64.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1+1i"\n"1+1i"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        a = a.substring(0, a.length() - 1);
        b = b.substring(0, b.length() - 1);
        String[] aa = a.split("\\+");
        String[] bb = b.split("\\+");
        int a1 = Integer.parseInt(aa[0]);
        int a2 = Integer.parseInt(aa[1]);
        int b1 = Integer.parseInt(bb[0]);
        int b2 = Integer.parseInt(bb[1]);
        int real = a1 * b1 - a2 * b2;
        int imagine = a1 * b2 + b1 * a2;
        return String.valueOf(real) + "+" + String.valueOf(imagine) + "i";
    }
}
