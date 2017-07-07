/*
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element
 *
 * Easy (46.27%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) vote++;
            else if (vote == 0) {
                candidate = nums[i];
                vote = 1;
            } else {
                vote--;
            }
        }
        return candidate;
    }
}
