/*
 * [503] Next Greater Element II
 *
 * https://leetcode.com/problems/next-greater-element-ii
 *
 * Medium (47.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }
        return res;
    }
}
