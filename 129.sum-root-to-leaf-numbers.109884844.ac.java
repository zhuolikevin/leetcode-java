/*
 * [129] Sum Root to Leaf Numbers
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 *
 * Medium (36.36%)
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
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root, 0);
        return res;
    }
    
    private void dfs(TreeNode node, int prefix) {
        int num = prefix * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += num;
            return;
        }
        if (node.left != null) {
            dfs(node.left, num);
        }
        if (node.right != null) {
            dfs(node.right, num);
        }
    }
}
