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
class Coor {
    int x;
    int y;
    Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
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
                    Queue<Coor> queue = new LinkedList<>();
                    queue.offer(new Coor(i, j));
                    grid[i][j] = 'x';
                    
                    while (!queue.isEmpty()) {
                        Coor coor = queue.poll();
                        int x = coor.x;
                        int y = coor.y;
                        if (x > 0 && grid[x - 1][y] == '1') {
                            queue.offer(new Coor(x - 1, y));
                            grid[x - 1][y] = 'x';
                        }
                        if (y > 0 && grid[x][y - 1] == '1') {
                            queue.offer(new Coor(x, y - 1));
                            grid[x][y - 1] = 'x';
                        }
                        if (x < m - 1 && grid[x + 1][y] == '1') {
                            queue.offer(new Coor(x + 1, y));
                            grid[x + 1][y] = 'x';
                        }
                        if (y < n - 1 && grid[x][y + 1] == '1') {
                            queue.offer(new Coor(x, y + 1));
                            grid[x][y + 1] = 'x';
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
