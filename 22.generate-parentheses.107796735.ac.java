/*
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses
 *
 * Medium (44.28%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int leftN, int rightN) {
        List<String> res = new ArrayList<>();
        if (leftN == 0) {
            String temp = "";
            for (int i = 0; i < rightN; i++) { temp += ")"; }
            res.add(temp);
            return res;
        }
        for (String remain : helper(leftN - 1, rightN)) {
            res.add("(" + remain);
        }
        if (rightN > 1 && rightN > leftN) {
            for (String remain : helper(leftN, rightN - 1)) {
                res.add(")" + remain);
            }
        }
        return res;
    }
}
