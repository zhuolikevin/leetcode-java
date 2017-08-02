/*
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow
 *
 * Medium (33.68%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] canReach = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, canReach, 1, res);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, canReach, 1, res);
        }
        
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, n - 1, canReach, -1, res);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, m - 1, j, canReach, -1, res);
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int x, int y, int[][] canReach, int flag, List<int[]> res) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        
        if (canReach[x][y] == -flag) {
            res.add(new int[] { x, y });
            canReach[x][y] = 2;
        } else {
            canReach[x][y] = flag;
        }
        
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            
            if (xx < 0 || xx >= m || yy < 0 || yy >= n ||
                canReach[xx][yy] == flag || canReach[xx][yy] == 2 || matrix[xx][yy] < matrix[x][y]) {
                continue;
            }
            
            dfs(matrix, xx, yy, canReach, flag, res);
        }
    }
}
