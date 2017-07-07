/*
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 *
 * Easy (47.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,null,3,2]'
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
    public int minDiff = Integer.MAX_VALUE;
    private TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;
        inorder(node.right);
    }
}
