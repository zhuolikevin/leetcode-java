/*
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference
 *
 * Medium (45.68%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timeMins = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] parts = timePoint.split(":");
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            timeMins.add(hour * 60 + min);
        }
        Collections.sort(timeMins);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < timeMins.size(); i++) {
            diff = Math.min(timeMins.get(i) - timeMins.get(i - 1), diff);
        }
        diff = Math.min(diff, timeMins.get(0) + 24 * 60 - timeMins.get(timeMins.size() - 1));
        return diff;
    }
}
