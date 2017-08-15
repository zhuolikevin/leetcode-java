/*
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands
 *
 * Medium (34.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["11110","11010","11000","00000"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = 'x';
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                
                for (int[] dir : dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || grid[xx][yy] != '1') {
                        continue;
                    }
                    
                    queue.offer(new int[] { xx, yy });
                    grid[xx][yy] = 'x';
                }
            }
        }
    }
}
