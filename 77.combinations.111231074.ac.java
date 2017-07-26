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
        
        search(res, candidates, k, 0, curComb);
        return res;
    }
    
    private void search(List<List<Integer>> res, List<Integer> candidates, int k, int start, List<Integer> curComb) {
        if (k == 0) {
            res.add(new ArrayList<>(curComb));
            return;
        }
        
        for (int i = start; i < candidates.size(); i++) {
            curComb.add(i + 1);
            search(res, candidates, k - 1, i + 1, curComb);
            curComb.remove(curComb.size() - 1);
        }
    }
}
