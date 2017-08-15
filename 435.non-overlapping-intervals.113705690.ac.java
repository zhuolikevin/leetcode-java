/*
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals
 *
 * Medium (41.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2]]'
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
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval inter1, Interval inter2) {
                return inter1.end - inter2.end;
            }
        });
        
        Interval prev = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            if (cur.start >= prev.end) {
                prev = cur;
            } else {
                count++;
            }
        }
        
        return count;
    }
}
