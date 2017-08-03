/*
 * [593] Valid Square
 *
 * https://leetcode.com/problems/valid-square
 *
 * Medium (39.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,0]\n[1,1]\n[1,0]\n[0,1]'
 *
 * Can you solve this problem? 🤔
 */
class Point implements Comparable<Point> {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point that) {
        if (this.y != that.y) {
            return this.y - that.y;
        } else if (this.x != that.x) {
            return this.x - that.x;
        } else {
            return 0;
        }
    }
}
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(p1[0], p1[1]));
        points.add(new Point(p2[0], p2[1]));
        points.add(new Point(p3[0], p3[1]));
        points.add(new Point(p4[0], p4[1]));
        
        Collections.sort(points);
        
        int len = getDist2(points.get(0), points.get(1));
        if (len == 0) {
            return false;
        }
        if (getDist2(points.get(0), points.get(2)) != len) {
            return false;
        }
        if (getDist2(points.get(1), points.get(3)) != len) {
            return false;
        }
        if (getDist2(points.get(2), points.get(3)) != len) {
            return false;
        }
        if (getDist2(points.get(1), points.get(2)) != 2 * len) {
            return false;
        }
        return true;
    }
    
    private int getDist2(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
