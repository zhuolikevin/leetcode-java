/*
 * [135] Candy
 *
 * https://leetcode.com/problems/candy
 *
 * Hard (24.60%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] left2Right = new int[ratings.length];
        int[] right2Left = new int[ratings.length];
        left2Right[0] = 1;
        right2Left[ratings.length - 1] = 1;
        
        for (int i = 1; i < ratings.length; i++) {
            left2Right[i] = ratings[i] > ratings[i - 1] ? left2Right[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            right2Left[i] = ratings[i] > ratings[i + 1] ? right2Left[i + 1] + 1 : 1;
        }
        
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2Right[i], right2Left[i]);
        }
        
        return sum;
    }
}
