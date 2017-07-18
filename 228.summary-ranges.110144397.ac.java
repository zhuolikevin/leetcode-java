/*
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges
 *
 * Medium (29.51%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                end = nums[i - 1];
                res.add(buildString(start, end));
                start = nums[i];
            }
        }
        end = nums[nums.length - 1];
        res.add(buildString(start, end));
        return res;
    }
    
    private String buildString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("->").append(end);
        }
        return sb.toString();
    }
}
