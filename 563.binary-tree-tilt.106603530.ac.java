/*
 * [563] Binary Tree Tilt
 *
 * https://leetcode.com/problems/binary-tree-tilt
 *
 * Easy (46.90%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
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
    public int tilt;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode node) {
        if (node == null) return 0;
        int sumLeft = traverse(node.left);
        int sumRight = traverse(node.right);
        tilt += Math.abs(sumLeft - sumRight);
        return node.val + sumLeft + sumRight;
    }
}
