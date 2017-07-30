/*
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle
 *
 * Hard (27.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["10100","10111","11111","10010"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 1];
        heights[n] = -1;
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= n; j++) {
                if (j < n) {
                    heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
                }
                while (!stack.isEmpty() && heights[j] <= heights[stack.peek()]) {
                    int index = stack.pop();
                    int right = j;
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    maxArea = Math.max(maxArea, heights[index] * (right - left - 1));
                }
                stack.push(j);
            }
        }
        
        return maxArea;
    }
}
