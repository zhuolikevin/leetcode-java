/*
 * [576] Out of Boundary Paths
 *
 * https://leetcode.com/problems/out-of-boundary-paths
 *
 * Medium (31.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2\n2\n2\n0\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        List<List<Map<Integer, Integer>>> cache = new ArrayList<>();
        for (int p = 0; p < m; p++) {
            List<Map<Integer, Integer>> row = new ArrayList<>();
            for (int q = 0; q < n; q++) {
                row.add(new HashMap<>());
            }
            cache.add(row);
        }
        return dfs(m, n, i, j, N, cache);
    }
    
    private int dfs(int m, int n, int i, int j, int N, List<List<Map<Integer, Integer>>> cache) {
        if (cache.get(i).get(j).containsKey(N)) {
            return cache.get(i).get(j).get(N);
        }
        
        if (N <= 0) {
            cache.get(i).get(j).put(N, 0);
            return 0;
        }
        
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= m || y < 0 || y >= n) {
                count = (count + 1) % 1000000007;
            } else {
                count = (count + dfs(m, n, x, y, N - 1, cache)) % 1000000007;
            }
        }
        
        cache.get(i).get(j).put(N, count);
        return count;
    }
}
