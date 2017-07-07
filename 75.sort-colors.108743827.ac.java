/*
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors
 *
 * Medium (37.69%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while (cur <= right) {
            if (nums[cur] == 1) {
                cur++;
            } else if (nums[cur] == 0) {
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                left++;
                cur++;
            } else {
                int temp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = temp;
                right--;
            }
        }
    }
}
