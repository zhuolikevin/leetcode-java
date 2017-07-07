/*
 * [617] Merge Two Binary Trees
 *
 * https://leetcode.com/problems/merge-two-binary-trees
 *
 * Easy (72.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3,2,5]\n[2,1,3,null,4,null,7]'
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) { return t2; }
        if (t2 == null) { return t1; }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{ t1, t2 });
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            TreeNode curLeft = t[0];
            TreeNode curRight = t[1];
            curLeft.val += curRight.val;
            if (curLeft.right == null && curRight.right != null) {
                curLeft.right = curRight.right;
            } else if (curLeft.right != null && curRight.right != null) {
                stack.push(new TreeNode[]{ curLeft.right, curRight.right});
            }
            if (curLeft.left == null && curRight.left != null) {
                curLeft.left = curRight.left;
            } else if (curLeft.left != null && curRight.left != null) {
                stack.push(new TreeNode[]{ curLeft.left, curRight.left});
            }
        }
        return t1;
    }
}
