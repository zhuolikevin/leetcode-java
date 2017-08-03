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
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        
        return res;
    }
}
