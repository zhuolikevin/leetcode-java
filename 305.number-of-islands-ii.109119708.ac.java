/*
 * [305] Number of Islands II
 *
 * https://leetcode.com/problems/number-of-islands-ii
 *
 * Hard (38.67%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '3\n3\n[[0,0],[0,1],[1,2],[2,1]]'
 *
 * Can you solve this problem? 🤔
 */
class UnionFind {
    int m;
    int n;
    int[][] map;
    public UnionFind(int m, int n) {
        this.m = m;
        this.n = n;
        this.map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.map[i][j] = i * n + j;
            }
        }
    }
    public void union(int p, int q) {
        int father1 = find(p);
        int father2 = find(q);
        if (father1 != father2) {
            map[father1 / n][father1 % n] = father2;
        }
    }
    public int find(int k) {
        int father = map[k / n][k % n];
        while (map[father / n][father % n] != father) {
            father = map[father / n][father % n];
        }
        int temp = map[k / n][k % n];
        map[k / n][k % n] = father;
        while (map[temp / n][temp % n] != father) {
            temp = map[temp / n][temp % n];
            map[temp / n][temp % n] = father;
        }
        return father;
    }
}
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions.length == 0) {
            return res;
        }
        
        int[][] matrix = new int[m][n];
        
        UnionFind uf = new UnionFind(m, n);
        int count = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] position : positions) {
            Set<Integer> set = new HashSet<>();
            int x = position[0];
            int y = position[1];
            matrix[x][y] = 1;
            
            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                
                if (xx < 0 || xx >= m || yy < 0 || yy >= n || matrix[xx][yy] != 1) {
                    continue;
                }
                
                set.add(uf.find(xx * n + yy));
                uf.union(x * n + y, xx * n + yy);
            }
            count = count - set.size() + 1;
            res.add(count);
        }
        
        return res;
    }
}
