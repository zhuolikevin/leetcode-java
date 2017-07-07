/*
 * [404] Sum of Left Leaves
 *
 * https://leetcode.com/problems/sum-of-left-leaves
 *
 * Easy (46.85%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,9,20,null,null,15,7]'
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
    public int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }
    private void traverse(TreeNode node) {
        if (node == null) return;
        if (node.left != null && isLeaf(node.left)) {
            sum += node.left.val;
        }
        traverse(node.left);
        traverse(node.right);
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
