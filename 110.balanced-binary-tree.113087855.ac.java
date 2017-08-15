/*
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree
 *
 * Easy (37.22%)
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
class ReturnType {
    int height;
    boolean isBalanced;
    ReturnType(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    private ReturnType helper(TreeNode node) {
        if (node == null) {
            return new ReturnType(0, true);
        }
        
        ReturnType left = helper(node.left);
        ReturnType right = helper(node.right);
        
        return new ReturnType(Math.max(left.height, right.height) + 1, left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1);
    }
}
