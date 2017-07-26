/*
 * [286] Walls and Gates
 *
 * https://leetcode.com/problems/walls-and-gates
 *
 * Medium (43.84%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int i, int j) {
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(i * n + j);
        visited.add(i * n + j);
        int dist = -1;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int index = queue.poll();
                int x = index / n;
                int y = index % n;
                rooms[x][y] = Math.min(rooms[x][y], dist);
                for (int[] dir : dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n ||
                        rooms[xx][yy] == -1 || rooms[xx][yy] == 0 || visited.contains(xx * n + yy)) {
                        continue;
                    }
                    queue.offer(xx * n + yy);
                    visited.add(xx * n + yy);
                }
            }
        }
    }
}
