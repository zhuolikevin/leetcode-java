/*
 * [210] Course Schedule II
 *
 * https://leetcode.com/problems/course-schedule-ii
 *
 * Medium (27.44%)
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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        
        Map<Integer, DirectedGraphNode> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new DirectedGraphNode(i));
        }
        for (int[] prerequisite : prerequisites) {
            int nodeVal = prerequisite[1];
            int childVal = prerequisite[0];
            DirectedGraphNode node = map.get(nodeVal);
            DirectedGraphNode child = map.get(childVal);
            node.children.add(child);
        }
        
        Map<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
        for (int val : map.keySet()) {
            for (DirectedGraphNode child : map.get(val).children) {
                inDegreeMap.put(child, inDegreeMap.getOrDefault(child, 0) + 1);
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        int resIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!inDegreeMap.containsKey(map.get(i))) {
                queue.offer(map.get(i));
                res[resIndex] = i;
                resIndex++;
            }
        }
        
        if (queue.isEmpty()) {
            return new int[0];
        }
        
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode child : node.children) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                if (inDegreeMap.get(child) == 0) {
                    queue.offer(child);
                    res[resIndex] = child.val;
                    resIndex++;
                }
            }
        }
        
        for (DirectedGraphNode node : inDegreeMap.keySet()) {
            if (inDegreeMap.get(node) != 0) {
                return new int[0];
            }
        }
        return res;
    }
}
