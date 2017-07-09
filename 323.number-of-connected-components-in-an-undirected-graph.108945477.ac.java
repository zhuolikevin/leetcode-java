/*
 * [323] Number of Connected Components in an Undirected Graph
 *
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
 *
 * Medium (47.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5\n[[0,1],[1,2],[3,4]]'
 *
 * Can you solve this problem? 🤔
 */
class UndirectedGraphNode {
    int val;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null || edges.length == 0) {
            return n;
        }
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new UndirectedGraphNode(i));
        }
        
        for (int[] edge : edges) {
            UndirectedGraphNode n1 = map.get(edge[0]);
            UndirectedGraphNode n2 = map.get(edge[1]);
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
        }
        
        int count = 0;
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            UndirectedGraphNode node = map.get(i);
            if (visited.contains(node)) {
                continue;
            }
            
            queue.offer(node);
            visited.add(node);
            while (!queue.isEmpty()) {
                UndirectedGraphNode curNode = queue.poll();
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}
