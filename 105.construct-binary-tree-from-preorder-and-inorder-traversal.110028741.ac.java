/*
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * Medium (32.00%)
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int leftCount = 0;
        while (inorder[inLeft + leftCount] != rootVal) {
            leftCount++;
        }
        
        root.left = build(preorder, preLeft + 1, preLeft + leftCount, inorder, inLeft, inLeft + leftCount - 1);
        root.right = build(preorder, preLeft + leftCount + 1, preRight, inorder, inLeft + leftCount + 1, inRight);
        return root;
    }
}
