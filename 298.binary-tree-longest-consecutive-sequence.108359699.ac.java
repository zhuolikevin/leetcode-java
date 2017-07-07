/*
 * [298] Binary Tree Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence
 *
 * Medium (40.67%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,null,3,2,4,null,null,null,5]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        
        stack.push(root);
        countStack.push(1);
        
        int maxCount = 1;
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = countStack.pop();
            if (node.left != null) {
                stack.push(node.left);
                if (node.left.val == node.val + 1) {
                    countStack.push(count + 1);
                    maxCount = Math.max(maxCount, count + 1);
                } else {
                    countStack.push(1);
                }
            }
            if (node.right != null) {
                stack.push(node.right);
                if (node.right.val == node.val + 1) {
                    countStack.push(count + 1);
                    maxCount = Math.max(maxCount, count + 1);
                } else {
                    countStack.push(1);
                }
            }
        }
        
        return maxCount;
    }
}
