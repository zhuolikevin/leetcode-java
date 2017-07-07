/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 *
 * Easy (47.11%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,3,4]\n6'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{ left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{ left + 1, right + 1 };
    }
}
