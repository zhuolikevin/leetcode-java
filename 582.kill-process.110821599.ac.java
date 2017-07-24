/*
 * [582] Kill Process
 *
 * https://leetcode.com/problems/kill-process
 *
 * Medium (48.35%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3,10,5]\n[3,0,5,3]\n5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        if (pid == null || pid.size() == 0 || ppid == null || ppid.size() == 0) {
            return res;
        }
        
        Map<Integer, List<Integer>> dict = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!dict.containsKey(ppid.get(i))) {
                dict.put(ppid.get(i), new ArrayList<>());
            }
            List<Integer> children = dict.get(ppid.get(i));
            children.add(pid.get(i));
            dict.put(ppid.get(i), children);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                res.add(p);
                if (dict.containsKey(p)) {
                    List<Integer> children = dict.get(p);
                    for (int child : children) {
                        queue.offer(child);
                    }
                }
            }
        }
        
        return res;
    }
}
