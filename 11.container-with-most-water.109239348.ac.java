/*
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water
 *
 * Medium (36.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        
        int curMax = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            curMax = Math.max(curMax, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return curMax;
    }
}
