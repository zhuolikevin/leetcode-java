/*
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators
 *
 * Hard (29.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"123"\n6'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        
        helper(res, num, "", (long)target, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String num, String path, long target, int start, long eval, long multiple) {
        if (start == num.length()) {
            if (eval == target) {
                res.add(path);
                return;
            }
        }
        
        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') {
                break;
            }
            
            long number = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                helper(res, num, path + number, target, i + 1, number, number);
            } else {
                helper(res, num, path + "+" + number, target, i + 1, eval + number, number);
                helper(res, num, path + "-" + number, target, i + 1, eval - number, -number);
                helper(res, num, path + "*" + number, target, i + 1, eval - multiple + multiple * number, multiple * number);
            }
        }
    }
}
