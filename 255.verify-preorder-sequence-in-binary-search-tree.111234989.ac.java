/*
 * [255] Verify Preorder Sequence in Binary Search Tree
 *
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree
 *
 * Medium (40.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                low = stack.pop();
            }
            stack.push(num);
        }
        
        return true;
    }
}
