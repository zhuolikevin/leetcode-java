/*
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs
 *
 * Easy (39.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) { return 0; }
        if (n == 1) { return 1; }
        int step = 2;
        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            step = first + second;
            first = second;
            second = step;
        }
        return step;
    }
}
