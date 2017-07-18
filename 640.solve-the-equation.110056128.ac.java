/*
 * [640] Solve the Equation
 *
 * https://leetcode.com/problems/solve-the-equation
 *
 * Medium (38.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"x+5-3+x=6+x-2"'
 *
 * Can you solve this problem? 🤔
 */
class Poly {
    int coef;
    int constant;
    Poly(int coef, int constant) {
        this.coef = coef;
        this.constant = constant;
    }
}
public class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        Poly left = simplyfyPoly(parts[0]);
        Poly right = simplyfyPoly(parts[1]);
        
        if (left.coef == right.coef && left.constant == right.constant) {
            return "Infinite solutions";
        } else if (left.coef == right.coef && left.constant != right.constant) {
            return "No solution";
        } else {
            int constant = right.constant - left.constant;
            int coef = left.coef - right.coef;
            int x = constant / coef;
            return "x=" + String.valueOf(x);
        }
    }
    
    private Poly simplyfyPoly(String str) {
        String[] parts = str.split("\\+|-");
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].equals("")) {
                ops.add(parts[i]);
            }
        }
        
        List<Boolean> signs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                signs.add(true);
            } else if (str.charAt(i) == '-') {
                signs.add(false);
            }
        }
        if (signs.size() < ops.size()) {
            signs.add(0, true);
        }
        
        int constant = 0;
        int coef = 0;
        for (int i = 0; i < ops.size(); i++) {
            String op = ops.get(i);
            if (op.indexOf('x') == -1) {
                constant = signs.get(i) ? constant + Integer.parseInt(op) : constant - Integer.parseInt(op);
            } else {
                int temp = op.equals("x") ? 1 : Integer.parseInt(op.substring(0, op.length() - 1));
                coef = signs.get(i) ? coef + temp : coef - temp;
            }
        }
        
        return new Poly(coef, constant);
    }
}
