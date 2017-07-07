/*
 * [592] Fraction Addition and Subtraction
 *
 * https://leetcode.com/problems/fraction-addition-and-subtraction
 *
 * Medium (46.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"-1/2+1/2"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String fractionAddition(String expression) {
        int num1, den1, num2, den2;
        boolean isPlus;
        int i = 0;
        while (expression.charAt(i) != '/') { i++; }
        num1 = Integer.parseInt(expression.substring(0, i));
        int j = i;
        while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') { j++; }
        den1 = Integer.parseInt(expression.substring(i + 1, j));
        if (j == expression.length()) { return expression; }
        
        isPlus = expression.charAt(j) == '+';
        i = j;
        while (expression.charAt(i) != '/') { i++; }
        num2 = Integer.parseInt(expression.substring(j + 1, i));
        j = i;
        while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') { j++; }
        den2 = Integer.parseInt(expression.substring(i + 1, j));
        
        int num = isPlus ? num1 * den2 + num2 * den1 : num1 * den2 - num2 * den1;
        int den = den1 * den2;
        
        String res = getIrreducible(num, den);
        
        return j == expression.length() ? res : fractionAddition(res + expression.substring(j));
    }
    
    private String getIrreducible(int num, int den) {
        boolean negative = num < 0;
        num = Math.abs(num);
        int gcd = gcd(num, den);
        String res = String.valueOf(num / gcd) + "/" + String.valueOf(den / gcd);
        return negative ? "-" + res : res;
    }
    
    private int gcd(int a, int b) {
        if (a == 0 || b == 0) { return a + b; }
        return gcd(b, a % b);
    }
}
