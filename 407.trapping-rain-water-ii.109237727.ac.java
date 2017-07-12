/*
 * [407] Trapping Rain Water II
 *
 * https://leetcode.com/problems/trapping-rain-water-ii
 *
 * Hard (36.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * Can you solve this problem? 🤔
 */
class Point {
    int x;
    int y;
    int val;
    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> heap = new PriorityQueue<>(2 * m + 2 * n - 4, new Comparator<Point>() {
            public int compare(Point p, Point q) {
                return p.val - q.val;
            }
        });
        
        initializeHeap(heightMap, visited, heap);
        
        int count = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!heap.isEmpty()) {
            Point p = heap.poll();
            
            for (int[] dir : dirs) {
                int xx = p.x + dir[0];
                int yy = p.y + dir[1];
                
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy]) {
                    continue;
                }
                
                if (heightMap[xx][yy] <= p.val) {
                    count += p.val - heightMap[xx][yy];
                }
                
                heap.offer(new Point(xx, yy, Math.max(heightMap[xx][yy], p.val)));
                visited[xx][yy] = true;
            }
        }
        
        return count;
    }
    
    private void initializeHeap(int[][] map, boolean[][] visited, Queue<Point> heap) {
        int m = map.length;
        int n = map[0].length;
        for (int i = 0; i < m; i += m - 1) {
            for (int j = 0; j < n; j++) {
                heap.offer(new Point(i, j, map[i][j]));
                visited[i][j] = true;
            }
        }
        for (int j = 0; j < n; j += n - 1) {
            for (int i = 1; i < m - 1; i++) {
                heap.offer(new Point(i, j, map[i][j]));
                visited[i][j] = true;
            }
        }
    }
}
