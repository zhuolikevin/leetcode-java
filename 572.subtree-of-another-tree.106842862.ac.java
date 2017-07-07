/*
 * [572] Subtree of Another Tree
 *
 * https://leetcode.com/problems/subtree-of-another-tree
 *
 * Easy (41.01%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) { return true; }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) { continue; }
            if (node.val == t.val && isSameTree(node, t)) {
                return true;
            }
            stack.push(node.right);
            stack.push(node.left);
        }
        return false;
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) { return true; }
        if (s != null && t == null) { return false; }
        if (s == null && t != null) { return false; }
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
