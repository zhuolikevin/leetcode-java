/*
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx
 *
 * Easy (27.67%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        
        long left = 1;
        long right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (right * right < x) {
            return (int)right;
        } else {
            return (int)left;
        }
    }
}
