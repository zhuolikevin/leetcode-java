/*
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line
 *
 * Hard (15.32%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        int maxCount = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            int overallCount = 1;
            int pointCount = 0;
            int verticalCount = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    overallCount++;
                } else if (p1.x == p2.x) {
                    verticalCount++;
                } else {
                    double n1 = (double)(p1.y - p2.y);
                    double n2 = (double)(p1.x - p2.x);
                    if (Math.abs(n1) > Math.pow(10, 7)) {
                        n1 *= Math.pow(10, -7);
                    }
                    if (Math.abs(n2) > Math.pow(10, 7)) {
                        n2 *= Math.pow(10, -7);
                    }
                    double slop = n1 / n2;
                    map.put(slop, map.getOrDefault(slop, 0) + 1);
                }
            }
            for (double slop : map.keySet()) {
                pointCount = Math.max(pointCount, map.get(slop));
            }
            pointCount = Math.max(pointCount, verticalCount) + overallCount;
            
            maxCount = Math.max(maxCount, pointCount);
        }
        
        return maxCount;
    }
}
