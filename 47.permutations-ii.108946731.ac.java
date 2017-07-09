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
        for (int i = 0; i < nums.length; i++) {
            candidates.add(nums[i]);
        }
        
        return helper(candidates);
    }
    
    private List<List<Integer>> helper(List<Integer> candidates) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.size() == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates.get(0));
            res.add(temp);
            return res;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            if (i > 0 && candidates.get(i) == candidates.get(i - 1)) {
                continue;
            }
            int curNum = candidates.get(i);
            candidates.remove(i);
            List<List<Integer>> remains = helper(candidates);
            for (List<Integer> remain : remains) {
                remain.add(0, curNum);
                res.add(remain);
            }
            candidates.add(i, curNum);
        }
        
        return res;
    }
}
