/*
 * [368] Largest Divisible Subset
 *
 * https://leetcode.com/problems/largest-divisible-subset
 *
 * Medium (33.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        
        int longest = 0;
        int longestIndex = -1;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    parent[i] = j;
                    if (dp[i] > longest) {
                        longest = dp[i];
                        longestIndex = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < longest; i++) {
            res.add(nums[longestIndex]);
            longestIndex = parent[longestIndex];
        }
        
        return res;
    }
}
