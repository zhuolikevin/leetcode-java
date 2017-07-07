/*
 * [441] Arranging Coins
 *
 * https://leetcode.com/problems/arranging-coins
 *
 * Easy (36.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int arrangeCoins(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (0.5 * mid * mid + 0.5 * mid <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
