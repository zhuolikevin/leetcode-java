/*
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water
 *
 * Hard (36.51%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int count = 0;
        int left = 0;
        int right = height.length - 1;
        int curHeight = Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                count += curHeight - height[left];
                left++;
                if (height[left] >= curHeight) {
                    curHeight = Math.min(height[left], height[right]);
                }
            } else {
                count += curHeight - height[right];
                right--;
                if (height[right] >= curHeight) {
                    curHeight = Math.min(height[left], height[right]);
                }
            }
        }
        
        return count;
    }
}
