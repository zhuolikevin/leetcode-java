/*
 * [317] Shortest Distance from All Buildings
 *
 * https://leetcode.com/problems/shortest-distance-from-all-buildings
 *
 * Hard (33.78%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        
        int buildingCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs(grid, i, j, distance, reach);
                }
            }
        }
        
        int minDist = Integer.MAX_VALUE;
        boolean find = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingCount) {
                    find = true;
                    minDist = Math.min(minDist, distance[i][j]);
                }
            }
        }
        
        return find ? minDist : -1;
    }
    
    private void bfs(int[][] grid, int i, int j, int[][] distance, int[][] reach) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        
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
                
                distance[x][y] += dist;
                reach[x][y] += 1;
                
                for (int[] dir : dirs) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited.contains(xx * n + yy) || grid[xx][yy] > 0) {
                        continue;
                    }
                    
                    queue.offer(xx * n + yy);
                    visited.add(xx * n + yy);
                }
            }
        }
    }
}
