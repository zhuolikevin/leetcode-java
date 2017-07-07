/*
 * [100] Same Tree
 *
 * https://leetcode.com/problems/same-tree
 *
 * Easy (46.25%)
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null && q != null) return false;
        else if (p != null && q == null) return false;
        else return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
