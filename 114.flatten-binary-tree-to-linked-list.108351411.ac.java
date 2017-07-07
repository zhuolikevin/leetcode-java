/*
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 *
 * Medium (34.76%)
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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);
        
        TreeNode right = node.right;
        if (leftTail != null) {
            node.right = node.left;
            node.left = null;
            leftTail.right = right;
        }
        
        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        } else {
            return node;
        }
    }
}
