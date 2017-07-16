/*
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum
 *
 * Hard (25.90%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3]'
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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        int sum = node.val;
        if (leftSum > 0) {
            sum += leftSum;
        }
        if (rightSum > 0) {
            sum += rightSum;
        }
        maxSum = Math.max(maxSum, sum);
        return node.val + Math.max(0, Math.max(leftSum, rightSum));
    }
}
