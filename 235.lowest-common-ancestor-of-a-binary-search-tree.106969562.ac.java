/*
 * [235] Lowest Common Ancestor of a Binary Search Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * Easy (38.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1]\nnode with value 2\nnode with value 1'
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) { return null; }
        if (root == p) { return p; }
        if (root == q) { return q; }
        if (p.val < root.val && root.val < q.val || q.val < root.val && root.val < p.val) { return root; }
        else if (p.val < root.val && q.val < root.val) { return lowestCommonAncestor(root.left, p, q); }
        else { return lowestCommonAncestor(root.right, p, q); }
    }
}
