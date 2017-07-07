/*
 * [104] Maximum Depth of Binary Tree
 *
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 *
 * Easy (52.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);
        
        int maxDepth = 1;
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node.left == null && node.right == null) maxDepth = Math.max(maxDepth, depth);
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
        }
        
        return maxDepth;
    }
}
