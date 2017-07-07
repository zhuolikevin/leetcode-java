/*
 * [452] Minimum Number of Arrows to Burst Balloons
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 *
 * Medium (43.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[10,16],[2,8],[1,6],[7,12]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
           @Override
           public int compare(int[] a, int[] b) {
               return b[0] - a[0];
           }
        });
        
        int i = 0;
        int count = 0;
        while (i < points.length) {
            count++;
            int start = points[i][0];
            while (i < points.length && points[i][0] <= start && points[i][1] >= start) {
                i++;
            }
        }
        return count;
    }
}
