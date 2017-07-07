/*
 * [241] Different Ways to Add Parentheses
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses
 *
 * Medium (43.41%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"2-1-1"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1, input.length());
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                for (int num1 : res1) {
                    for (int num2 : res2) {
                        switch (curChar) {
                            case '+':
                                res.add(num1 + num2);
                                break;
                            case '-':
                                res.add(num1 - num2);
                                break;
                            case '*':
                                res.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
