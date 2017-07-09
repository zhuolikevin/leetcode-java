/*
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii
 *
 * Medium (33.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curCombination, int start, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curCombination));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            curCombination.add(candidates[i]);
            helper(res, curCombination, i + 1, candidates, target - candidates[i]);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
