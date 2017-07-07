/*
 * [492] Construct the Rectangle
 *
 * https://leetcode.com/problems/construct-the-rectangle
 *
 * Easy (48.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int L = (int)Math.sqrt(area);
        if (L * L == area) {
            return new int[]{ L, L };
        } else {
            L++;
        }
        int W;
        while (L <= area) {
            if (area % L == 0) {
              W = area / L;
              return new int[]{ L, W };
            }
            L++;
        }
        return new int[]{ area, 1 };
    }
}
