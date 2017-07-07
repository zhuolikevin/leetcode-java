/*
 * [475] Heaters
 *
 * https://leetcode.com/problems/heaters
 *
 * Easy (29.49%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = - (index + 1);
                int leftDis = index > 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int rightDis = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                res = Math.max(res, Math.min(leftDis, rightDis));
            }
        }
        return res;
    }
}
