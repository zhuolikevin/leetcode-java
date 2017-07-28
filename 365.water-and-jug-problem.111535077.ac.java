/*
 * [365] Water and Jug Problem
 *
 * https://leetcode.com/problems/water-and-jug-problem
 *
 * Medium (27.32%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3\n5\n4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        if (x == 0 || y == 0) {
            return x + y;
        }
        return gcd(y, x % y);
    }
}
