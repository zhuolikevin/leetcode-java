/*
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * Medium (31.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n[]'
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft > postRight) {
            return null;
        }
        if (postLeft == postRight) {
            return new TreeNode(postorder[postLeft]);
        }
        
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int rightCount = 0;
        while (inorder[inRight - rightCount] != rootVal) {
            rightCount++;
        }
        
        root.right = build(postorder, postRight - rightCount, postRight - 1, inorder, inRight - rightCount + 1, inRight);
        root.left = build(postorder, postLeft, postRight - rightCount - 1, inorder, inLeft, inRight - rightCount - 1);
        return root;
    }
}
