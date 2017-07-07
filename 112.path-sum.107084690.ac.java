/*
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum
 *
 * Easy (33.75%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n1'
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        return dfs(root, 0, sum);
    }
    private boolean dfs(TreeNode node, int curSum, int sum) {
        if (node.left == null && node.right == null) {
            return curSum + node.val == sum;
        }
        boolean leftRes = node.left != null ? dfs(node.left, curSum + node.val, sum) : false;
        boolean rightRes = node.right != null ? dfs(node.right, curSum + node.val, sum) : false;
        return leftRes || rightRes;
    }
}
