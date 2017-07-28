/*
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary
 *
 * Medium (29.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
        
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new PriorityQueue<>());
            }
            graph.get(ticket[0]).offer(ticket[1]);
        }
        
        visit(res, "JFK", graph);
        return res;
    }
    
    private void visit(List<String> res, String dep, Map<String, PriorityQueue<String>> graph) {
        while (graph.containsKey(dep) && !graph.get(dep).isEmpty()) {
            visit(res, graph.get(dep).poll(), graph);
        }
        res.add(0, dep);
    }
}
