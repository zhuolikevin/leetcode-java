/*
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree
 *
 * Medium (23.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1,3]'
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
    public boolean isValidBST(TreeNode root) {
        TreeNode lastNode = null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (lastNode != null && lastNode.val >= node.val) {
                    return false;
                }
                lastNode = node;
                node = node.right;
            }
        }
        return true;
    }
}
