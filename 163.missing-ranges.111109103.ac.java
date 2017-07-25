/*
 * [163] Missing Ranges
 *
 * https://leetcode.com/problems/missing-ranges
 *
 * Medium (24.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1,3,50,75]\n0\n99'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long start = (long)lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                res.add(formRange(start, (long)nums[i] - 1));
                start = (long)nums[i] + 1;
            } else if (nums[i] == start) {
                start++;
            }
        }
        if (start <= (long)upper) {
            res.add(formRange(start, upper));
        }
        
        return res;
    }
    
    private String formRange(long left, long right) {
        if (left == right) {
            return String.valueOf(left);
        } else {
            return String.valueOf(left) + "->" + String.valueOf(right);
        }
    }
}
