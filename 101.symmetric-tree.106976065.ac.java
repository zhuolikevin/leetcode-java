/*
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree
 *
 * Easy (38.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,2,3,4,4,3]'
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        else { return isSymmetricTrees(root.left, root.right); }
    }
    private boolean isSymmetricTrees(TreeNode n1, TreeNode n2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(n1);
        s2.push(n2);
        while (!s1.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();
            if (node1 == null && node2 == null) { continue; }
            if (node1 == null && node2 != null || node1 != null && node2 == null) { return false; }
            if (node1.val != node2.val) { return false; }
            s1.push(node1.left);
            s2.push(node2.right);
            s1.push(node1.right);
            s2.push(node2.left);
        }
        return true;
    }
}
