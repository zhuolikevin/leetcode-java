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
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode newNode = new UndirectedGraphNode(curNode.label);
            visited.add(curNode);
            map.put(curNode, newNode);
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        
        visited.clear();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode newNode = map.get(curNode);
            visited.add(curNode);
            
            for (UndirectedGraphNode neighbor : curNode.neighbors) {
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
