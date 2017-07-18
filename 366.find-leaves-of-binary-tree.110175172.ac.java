/*
 * [366] Find Leaves of Binary Tree
 *
 * https://leetcode.com/problems/find-leaves-of-binary-tree
 *
 * Medium (59.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4,5]'
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        helper(res, root);
        return res;
    }
    
    private int helper(List<List<Integer>> res, TreeNode node) {
        if (node == null) {
            return -1;
        }
        
        int leftDepth = helper(res, node.left);
        int rightDepth = helper(res, node.right);
        int depth = Math.max(leftDepth, rightDepth) + 1;
        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(node.val);
        return depth;
    }
}
