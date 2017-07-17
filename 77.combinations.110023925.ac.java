/*
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations
 *
 * Medium (39.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '4\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || k <= 0) {
            return res;
        }
        List<Integer> curComb = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i<= n; i++) {
            candidates.add(i);
        }
        
        search(res, candidates, k, curComb);
        return res;
    }
    
    private void search(List<List<Integer>> res, List<Integer> candidates, int k, List<Integer> curComb) {
        if (k == 0) {
            res.add(curComb);
            return;
        }
        
        int size = candidates.size();
        while (candidates.size() >= k) {
            List<Integer> newComb = new ArrayList<>(curComb);
            newComb.add(candidates.get(0));
            candidates.remove(0);
            List<Integer> newCand = new ArrayList<>(candidates);
            search(res, newCand, k - 1, newComb);
        }
    }
}
