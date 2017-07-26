/*
 * [254] Factor Combinations
 *
 * https://leetcode.com/problems/factor-combinations
 *
 * Medium (42.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '12'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }
        
        helper(res, n, new ArrayList<>(), 2);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, List<Integer> curFactors, int start) {
        if (n <= 1) {
            if (curFactors.size() > 1) {
                res.add(new ArrayList<>(curFactors));
            }
            return;
        }
        
        for (int i = start; i <= n ; i++) {
            if (n % i == 0) {
                curFactors.add(i);
                helper(res, n / i, curFactors, i);
                curFactors.remove(curFactors.size() - 1);
            }
        }
    }
}
