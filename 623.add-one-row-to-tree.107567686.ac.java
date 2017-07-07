/*
 * [623] Add One Row to Tree
 *
 * https://leetcode.com/problems/add-one-row-to-tree
 *
 * Medium (48.80%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4,2,6,3,1,5]\n1\n2'
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        nodeQ.add(root);
        depthQ.add(1);
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.remove();
            int depth = depthQ.remove();
            if (node == null) { continue; }
            if (depth == d - 1) {
                TreeNode newLeft = new TreeNode(v);
                TreeNode newRight = new TreeNode(v);
                newLeft.left = node.left;
                newRight.right = node.right;
                node.left = newLeft;
                node.right = newRight;
            } else {
                nodeQ.add(node.left);
                nodeQ.add(node.right);
                depthQ.add(depth + 1);
                depthQ.add(depth + 1);
            }
        }
        return root;
    }
}
