/*
 * [490] The Maze
 *
 * https://leetcode.com/problems/the-maze
 *
 * Medium (42.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]\n[0,4]\n[4,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            if (s[0] == destination[0] && s[1] == destination[1]) {
                return true;
            }
            
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    queue.offer(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
