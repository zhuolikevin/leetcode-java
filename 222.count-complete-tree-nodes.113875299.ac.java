/*
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes
 *
 * Medium (27.39%)
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight > rightHeight) {
            return (1 << rightHeight) + countNodes(root.left);
        } else {
            return (1 << leftHeight) + countNodes(root.right);
        }
    }
    
    private int getHeight(TreeNode root) {
        TreeNode cur = root;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.left;
        }
        
        return count;
    }
}
