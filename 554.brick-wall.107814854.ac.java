/*
 * [554] Brick Wall
 *
 * https://leetcode.com/problems/brick-wall
 *
 * Medium (44.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++ ) {
            int temp = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                temp += wall.get(i).get(j);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        int maxCount = 0;
        for (int key : map.keySet()) {
            maxCount = Math.max(maxCount, map.get(key));
        }
        return wall.size() - maxCount;
    }
}
