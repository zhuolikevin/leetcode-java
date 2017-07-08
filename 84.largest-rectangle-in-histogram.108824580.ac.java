/*
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram
 *
 * Hard (26.42%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int curMax = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int curHeightIndex = stack.pop();
                    int right = i;
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    curMax = Math.max(curMax, heights[curHeightIndex] * (right - left - 1));
                }
                stack.push(i);
            }
        }
        
        int right = heights.length;
        while (!stack.isEmpty()) {
            int curHeightIndex = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
             curMax = Math.max(curMax, heights[curHeightIndex] * (right - left - 1));
        }
        
        return curMax;
    }
}
