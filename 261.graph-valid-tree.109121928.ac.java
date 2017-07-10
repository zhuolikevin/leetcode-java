/*
 * [261] Graph Valid Tree
 *
 * https://leetcode.com/problems/graph-valid-tree
 *
 * Medium (37.51%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5\n[[0,1],[0,2],[2,3],[2,4]]'
 *
 * Can you solve this problem? 🤔
 */
class UnionFind {
    int[] table;
    public UnionFind(int n) {
        table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = i;
        }
    }
    public void union(int p, int q) {
        int father1 = find(p);
        int father2 = find(q);
        if (father1 != father2) {
            table[father1] = father2;
        }
    }
    public int find(int k) {
        int father = table[k];
        if (table[father] != father) {
            father = table[father];
        }
        return father;
    }
}
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0 || edges.length != n - 1) {
            return false;
        }
        if (n == 0 || n == 1 && edges.length == 0) {
            return true;
        }
        
        Set<Integer> visited = new HashSet<>();
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            visited.add(edge[0]);
            visited.add(edge[1]);
            int father1 = uf.find(edge[0]);
            int father2 = uf.find(edge[1]);
            if (father1 == father2) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return n == visited.size();
    }
}
