/*
 * [296] Best Meeting Point
 *
 * https://leetcode.com/problems/best-meeting-point
 *
 * Hard (51.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]'
 *
 * Can you solve this problem? 🤔
 */
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        List<Point> persons = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    persons.add(new Point(i, j));
                }
            }
        }
        
        Collections.sort(persons, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.x - p2.x;
            }
        });
        
        int x = persons.get(persons.size() / 2).x;
        
        Collections.sort(persons, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.y - p2.y;
            }
        });
        
        int y = persons.get(persons.size() / 2).y;
        
        int sum = 0;
        for (Point person : persons) {
            sum += Math.abs(x - person.x) + Math.abs(y - person.y);
        }
        
        return sum;
    }
}
