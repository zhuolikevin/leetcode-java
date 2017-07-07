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
    int depth;
    boolean isBalanced;
    ReturnType(int depth, boolean isBalanced) {
        this.depth = depth;
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
        
        int depth = Math.max(left.depth, right.depth) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1;
        
        return new ReturnType(depth, isBalanced);
    }
}
