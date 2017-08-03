/*
 * [505] The Maze II
 *
 * https://leetcode.com/problems/the-maze-ii
 *
 * Medium (36.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]\n[0,4]\n[4,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }
        
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (dist[s[0]][s[1]] + count < dist[x][y]) {
                    dist[x][y] = dist[s[0]][s[1]] + count;
                    queue.add(new int[] {x, y});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
