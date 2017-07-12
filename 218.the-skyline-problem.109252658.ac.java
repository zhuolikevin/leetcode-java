/*
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem
 *
 * Hard (26.86%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * Can you solve this problem? 🤔
 */
class Point implements Comparable<Point> {
    int time;
    int height;
    boolean isStart;
    Point(int time, int height, boolean isStart) {
        this.time = time;
        this.height = height;
        this.isStart = isStart;
    }
    @Override
    public int compareTo(Point that) {
        if (this.isStart == that.isStart && this.time == that.time) {
            if (this.isStart) {
                return that.height - this.height;
            } else {
                return this.height - that.height;
            }
        } else if (this.isStart == that.isStart || this.time != that.time) {
            return this.time - that.time;
        } else {
            if (this.isStart) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        
        List<Point> points = new ArrayList<>();
        for (int[] tuple : buildings) {
            points.add(new Point(tuple[0], tuple[2], true));
            points.add(new Point(tuple[1], tuple[2], false));
        }
        Collections.sort(points);
        
        Queue<Integer> heap = new PriorityQueue<>(buildings.length, Collections.reverseOrder());
        for (Point point : points) {
            if (point.isStart) {
                if (heap.isEmpty() || point.height > heap.peek()) {
                    int[] temp = new int[] { point.time, point.height };
                    res.add(temp);
                }
                heap.offer(point.height);
            } else {
                if (point.height < heap.peek()) {
                    heap.remove(point.height);
                    continue;
                }
                int peakHeight = heap.poll();
                if (heap.isEmpty() || point.height > heap.peek()) {
                    int[] temp = new int[] { point.time, heap.isEmpty() ? 0 : heap.peek() };
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
}
