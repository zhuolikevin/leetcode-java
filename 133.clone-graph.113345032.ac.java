/*
 * [133] Clone Graph
 *
 * https://leetcode.com/problems/clone-graph
 *
 * Medium (25.09%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '{}'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            map.put(cur, new UndirectedGraphNode(cur.label));
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        visited.clear();
        queue.offer(node);
        visited.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode newNode = map.get(cur);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        return map.get(node);
    }
}
