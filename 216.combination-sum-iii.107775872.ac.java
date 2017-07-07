/*
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii
 *
 * Medium (44.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3\n7'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n > 45) { return res; }
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            candidates.add(i);
        }
        return helper(candidates, k, n, 1);
    }
    
    private List<List<Integer>> helper(List<Integer> candidates, int k, int n, int startNum) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.size(); i++) {
            int curNum = candidates.get(i);
            if (curNum < startNum) { continue; }
            if (k == 1) {
                if (curNum == n) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curNum);
                    res.add(list);
                    break;
                }
            }
            if (curNum >= n) { break; }
            
            candidates.remove(Integer.valueOf(curNum));
            List<List<Integer>> remains = helper(candidates, k - 1, n - curNum, curNum + 1);
            for (List<Integer> remain : remains) {
                remain.add(0, curNum);
                res.add(remain);
            }
            candidates.add(i, curNum);
        }
        return res;
    }
}
