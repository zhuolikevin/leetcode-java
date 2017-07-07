/*
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii
 *
 * Medium (43.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,2,3,null,3,null,1]'
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
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] helper(TreeNode node) {
        int[] res = new int[2];
        if (node == null) { return res; }
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}
