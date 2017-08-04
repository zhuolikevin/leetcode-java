/*
 * [473] Matchsticks to Square
 *
 * https://leetcode.com/problems/matchsticks-to-square
 *
 * Medium (35.14%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,2,2,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        
        int sum = 0;
        List<Integer> candidates = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            candidates.add(num);
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        Collections.sort(candidates, Collections.reverseOrder());
        return search(candidates, 0, sum / 4, sum / 4);
    }
    
    private boolean search(List<Integer> candidates, int completed, int remain, int target) {
        if (remain == 0) {
            completed++;
            if (completed == 4) {
                return candidates.size() == 0;
            }
            return search(candidates, completed, target, target);
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            int num = candidates.get(i);
            if (num > target) {
                return false;
            }
            if (num > remain) {
                break;
            }
            
            candidates.remove(i);
            boolean find = search(candidates, completed, remain - num, target);
            candidates.add(i, num);
            
            if (find) {
                return true;
            }
        }
        
        return false;
    }
}
