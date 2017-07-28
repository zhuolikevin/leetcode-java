/*
 * [356] Line Reflection
 *
 * https://leetcode.com/problems/line-reflection
 *
 * Medium (30.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,1],[-1,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length <= 1) {
            return true;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> xSet = new HashSet<>();
        for (int[] point : points) {
            xSet.add(point[0]);
            if (!map.containsKey(point[0])) {
                map.put(point[0], new HashSet<>());
            }
            map.get(point[0]).add(point[1]);
        }
        
        List<Integer> xList = new ArrayList<>(xSet);
        Collections.sort(xList);
        
        int left = 0;
        int right = xList.size() - 1;
        double mid = ((double)xList.get(left) + (double)xList.get(right)) / 2;
        while (left <= right) {
            if (mid != ((double)xList.get(left) + (double)xList.get(right)) / 2) {
                return false;
            }
            if (!map.get(xList.get(left)).equals(map.get(xList.get(right)))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
