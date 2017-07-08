/*
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule
 *
 * Medium (31.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2\n[[1,0]]'
 *
 * Can you solve this problem? 🤔
 */
class DirectedGraphNode {
    int val;
    List<DirectedGraphNode> children;
    DirectedGraphNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        Map<Integer, DirectedGraphNode> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int nodeVal = prerequisite[1];
            int childVal = prerequisite[0];
            DirectedGraphNode node = map.getOrDefault(nodeVal, new DirectedGraphNode(nodeVal));
            DirectedGraphNode child = map.getOrDefault(childVal, new DirectedGraphNode(childVal));
            map.put(nodeVal, node);
            map.put(childVal, child);
            node.children.add(child);
        }
        
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (int val : map.keySet()) {
            for (DirectedGraphNode child : map.get(val).children) {
                inDegreeMap.put(child, inDegreeMap.getOrDefault(child, 0) + 1);
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (int val : map.keySet()) {
            if (!inDegreeMap.containsKey(map.get(val))) {
                queue.offer(map.get(val));
            }
        }
        
        if (queue.isEmpty()) {
            return false;
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode child : node.children) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                if (inDegreeMap.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }
        
        for (DirectedGraphNode node : inDegreeMap.keySet()) {
            if (inDegreeMap.get(node) != 0) {
                return false;
            }
        }
        return true;
    }
}
