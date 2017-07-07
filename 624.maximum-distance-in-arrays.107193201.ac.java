/*
 * [624] Maximum Distance in Arrays
 *
 * https://leetcode.com/problems/maximum-distance-in-arrays
 *
 * Easy (32.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,2,3],[4,5],[1,2,3]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE - 1;
        int secondMin = min + 1;
        int max = Integer.MIN_VALUE + 1;
        int secondMax = max - 1;
        int minIndex = 0; int maxIndex = 0;
        
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int size = list.size();
            if (list.get(0) < min) {
                secondMin = min;
                min = list.get(0);
                minIndex = i;
            } else if (list.get(0) < secondMin) {
                secondMin = list.get(0);
            }
            
            if (list.get(size - 1) > max) {
                secondMax = max;
                max = list.get(size - 1);
                maxIndex = i;
            } else if (list.get(size - 1) > secondMax) {
                secondMax = list.get(size - 1);
            }
        }
        
        return minIndex != maxIndex ? max - min : Math.max(max - secondMin, secondMax - min);
    }
}
