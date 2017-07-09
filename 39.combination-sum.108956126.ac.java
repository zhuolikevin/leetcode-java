/*
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum
 *
 * Medium (38.02%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            
            curCombination.add(candidates[i]);
            helper(res, curCombination, i, candidates, target - candidates[i]);
            curCombination.remove(curCombination.size() - 1);
        }
    }
}
