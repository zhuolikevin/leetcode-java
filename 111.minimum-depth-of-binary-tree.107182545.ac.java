/*
 * [111] Minimum Depth of Binary Tree
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 *
 * Easy (32.94%)
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
    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        queue.add(root);
        depthQ.add(1);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = depthQ.poll();
            if (node.left == null && node.right == null) { return depth; }
            if (node.left != null) {
                queue.add(node.left);
                depthQ.add(depth + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                depthQ.add(depth + 1);
            }
        }
        return -1;
    }
}
