/*
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii
 *
 * Medium (32.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        List<Integer> candidates = new ArrayList<>();
        for (int num : nums) {
            candidates.add(num);
        }
        
        search(res, candidates, new ArrayList<>());
        return res;
    }
    
    private void search(List<List<Integer>> res, List<Integer> candidates, List<Integer> items) {
        if (candidates.size() == 0) {
            res.add(new ArrayList<>(items));
            return;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            if (i > 0 && candidates.get(i) == candidates.get(i - 1)) {
                continue;
            }
            
            int number = candidates.get(i);
            candidates.remove(Integer.valueOf(number));
            items.add(number);
            search(res, candidates, items);
            items.remove(items.size() - 1);
            candidates.add(i, number);
        }
    }
}
