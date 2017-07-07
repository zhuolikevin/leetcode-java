/*
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs
 *
 * Easy (44.65%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) { return 0; }
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) { continue; }
                
                int d = distance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int val : map.values()) {
                count += val * (val - 1);
            }
            map.clear();
        }

        return count;
    }
    
    private int distance(int[] p1, int[] p2) {
        int d1 = p1[0] - p2[0];
        int d2 = p1[1] - p2[1];
        return d1 * d1 + d2 * d2;
    }
}
