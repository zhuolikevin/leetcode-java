/*
 * [156] Binary Tree Upside Down
 *
 * https://leetcode.com/problems/binary-tree-upside-down
 *
 * Medium (44.18%)
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prevLeft = null;
        TreeNode prevRight = null;
        while (cur != null) {
            TreeNode temp = cur.left;
            cur.left = null;
            TreeNode tempLeft = cur.right;
            cur.right = null;
            TreeNode tempRight = cur;
            if (prevRight != null) {
                cur.left = prevLeft;
                cur.right = prevRight;
            }
            prevLeft = tempLeft;
            prevRight = tempRight;
            if (temp != null) {
                cur = temp;
            } else {
                break;
            }
        }
        
        return cur;
    }
}
