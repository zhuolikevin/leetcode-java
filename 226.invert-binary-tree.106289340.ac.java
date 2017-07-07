/*
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree
 *
 * Easy (51.42%)
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
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            stack.push(node.left);
            stack.push(node.right);
        }
        return root;
    }
}
