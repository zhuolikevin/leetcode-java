/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii
 *
 * Medium (35.72%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            res.add(new ArrayList<>());
            List<Integer> temp = new ArrayList<>();
            temp.add(candidates.get(0));
            res.add(temp);
            return res;
        }
        
        int curNum = candidates.get(0);
        candidates.remove(0);
        List<List<Integer>> remains = helper(candidates);
        for (List<Integer> remain : remains) {
            res.add(remain);
            List<Integer> temp = new ArrayList<>(remain);
            temp.add(0, curNum);
            res.add(temp);
        }
        
        return new ArrayList<>(new HashSet<List<Integer>>(res));
    }
}
