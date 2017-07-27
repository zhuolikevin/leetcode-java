/*
 * [310] Minimum Height Trees
 *
 * https://leetcode.com/problems/minimum-height-trees
 *
 * Medium (28.78%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '4\n[[1,0],[1,2],[1,3]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodes.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int adj = nodes.get(leaf).get(0);
                nodes.get(adj).remove(Integer.valueOf(leaf));
                if (nodes.get(adj).size() == 1) {
                    newLeaves.add(adj);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
