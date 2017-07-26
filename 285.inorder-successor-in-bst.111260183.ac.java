/*
 * [285] Inorder Successor in BST
 *
 * https://leetcode.com/problems/inorder-successor-in-bst
 *
 * Medium (36.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0]\nnode with value 0'
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev == p) {
                    return cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        return null;
    }
}
