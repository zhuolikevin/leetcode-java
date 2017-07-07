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
        List<Integer> candidates = new ArrayList<>();
        for (int num : nums) {
            candidates.add(num);
        }
        return helper(candidates);
    }
    
    private List<List<Integer>> helper(List<Integer> candidates) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.size() == 0) {
            List<Integer> temp = new ArrayList<>();
            res.add(temp);
            return res;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            int num = candidates.get(i);
            candidates.remove(i);
            List<List<Integer>> remains = helper(candidates);
            for (List<Integer> remain : remains) {
                remain.add(0, num);
                res.add(remain);
            }
            candidates.add(i, num);
        }
        return res;
    }
}
