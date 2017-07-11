/*
 * [252] Meeting Rooms
 *
 * https://leetcode.com/problems/meeting-rooms
 *
 * Easy (46.92%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
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
            if (this.isStart && !that.isStart) {
                return 1;
            } else {
                return -1;
            }
        }
        
    }
}

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, true));
            points.add(new Point(interval.end, false));
        }
        
        Collections.sort(points);
        
        int count = 0;
        for (Point point : points) {
            if (point.isStart) {
                count++;
                if (count >= 2) {
                    return false;
                }
            } else {
                count--;
            }
        }
        
        return true;
    }
}
