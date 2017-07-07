/*
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths
 *
 * Easy (37.75%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,null,5]'
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
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) { return res; }
        dfs(root, new ArrayList<String>());
        return res;
    }
    
    private void dfs(TreeNode node, List<String> curPath) {
        List<String> newCurPath = new ArrayList<>(curPath);
        newCurPath.add(String.valueOf(node.val));
        if (node.left != null) { dfs(node.left, newCurPath); }
        if (node.right != null) { dfs(node.right, newCurPath); }
        if (node.left == null && node.right == null) {
            String path = String.join("->", newCurPath);
            res.add(path);
        }
    }
}
