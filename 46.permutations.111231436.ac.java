/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations
 *
 * Medium (43.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        for (int num : nums) {
            candidates.add(num);
        }
        dfs(res, candidates, new ArrayList<>());
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> candidates, List<Integer> items) {
        if (candidates.size() == 0) {
            res.add(new ArrayList<>(items));
            return;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            int num = candidates.get(i);
            candidates.remove(i);
            items.add(num);
            dfs(res, candidates, items);
            items.remove(items.size() - 1);
            candidates.add(i, num);
        }
    }
}
