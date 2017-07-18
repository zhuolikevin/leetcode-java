/*
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals
 *
 * Medium (29.80%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Point implements Comparable<Point> {
    int time;
    boolean isStart;
    Point(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }
    @Override
    public int compareTo(Point that) {
        if (this.time != that.time || this.isStart == that.isStart) {
            return this.time - that.time;
        } else {
            return this.isStart ? -1 : 1;
        }
    }
}
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        Collections.sort(points);
        
        Stack<Point> stack = new Stack<>();
        for (Point point : points) {
            if (point.isStart) {
                stack.push(point);
            } else {
                Point lastStart = stack.pop();
                if (stack.isEmpty()) {
                    res.add(new Interval(lastStart.time, point.time));
                }
            }
        }
        
        return res;
    }
}
