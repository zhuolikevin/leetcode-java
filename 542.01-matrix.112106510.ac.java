/*
 * [542] 01 Matrix
 *
 * https://leetcode.com/problems/01-matrix
 *
 * Medium (32.99%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(i * n + j);
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int x = index / n;
            int y = index % n;

            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];

                if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                    continue;
                }
                
                if (res[xx][yy] > res[x][y] + 1) {
                    res[xx][yy] = res[x][y] + 1;
                    queue.offer(xx * n + yy);
                }
            }
        }
        
        return res;
    }
}
