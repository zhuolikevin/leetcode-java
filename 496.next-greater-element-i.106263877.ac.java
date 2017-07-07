/*
 * [496] Next Greater Element I
 *
 * https://leetcode.com/problems/next-greater-element-i
 *
 * Easy (57.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}
