/*
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.com/problems/diameter-of-binary-tree
 *
 * Easy (43.25%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4,5]'
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
    public int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return diameter;
    }
    private int traverse(TreeNode node) {
        if (node == null) { return -1; }
        int leftMaxDepth = traverse(node.left) + 1;
        int rightMaxDepth = traverse(node.right) + 1;
        diameter = Math.max(diameter, leftMaxDepth + rightMaxDepth);
        return Math.max(leftMaxDepth, rightMaxDepth);
    }
}
