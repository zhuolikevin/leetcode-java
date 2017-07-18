/*
 * [636] Exclusive Time of Functions
 *
 * https://leetcode.com/problems/exclusive-time-of-functions
 *
 * Medium (31.89%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2\n["0:start:0","1:start:2","1:end:5","0:end:6"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[0];
        }
        
        int[] res = new int[n];
        int[] lastStartTime = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            boolean start = parts[1].equals("start");
            int timePoint = Integer.parseInt(parts[2]);
            
            if (start) {
                if (stack.isEmpty()) {
                    stack.push(id);
                    lastStartTime[id] = timePoint;
                } else {
                    int formerId = stack.peek();
                    res[formerId] = res[formerId] + timePoint - lastStartTime[formerId];
                    stack.push(id);
                    lastStartTime[id] = timePoint;
                }
            } else {
                stack.pop();
                res[id] = res[id] + timePoint - lastStartTime[id] + 1;
                if (!stack.isEmpty()) {
                    lastStartTime[stack.peek()] = timePoint + 1;
                }
            }
        }
        
        return res;
    }
}
