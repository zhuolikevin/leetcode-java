/*
 * [34] Search for a Range
 *
 * https://leetcode.com/problems/search-for-a-range
 *
 * Medium (31.27%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        } else {
            return res;
        }
        
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            res[1] = end;
        } else if (nums[start] == target) {
            res[1] = start;
        } else {
            return res;
        }
        
        return res;
    }
}
