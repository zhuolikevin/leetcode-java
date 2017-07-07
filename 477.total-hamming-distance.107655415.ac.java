/*
 * [477] Total Hamming Distance
 *
 * https://leetcode.com/problems/total-hamming-distance
 *
 * Medium (46.28%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,14,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num >> i & 1) != 0) { count++; }
            }
            res += count * (nums.length - count);
        }
        return res;
    }
}
