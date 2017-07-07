/*
 * [513] Find Bottom Left Tree Value
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value
 *
 * Medium (55.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1,3]'
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        nodeQ.add(root);
        depthQ.add(1);
        int curMaxDepth = 1;
        int candidateVal = root.val;
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.remove();
            int depth = depthQ.remove();
            if (depth > curMaxDepth) {
                curMaxDepth = depth;
                candidateVal = node.val;
            }
            if (node.left != null) {
                nodeQ.add(node.left);
                depthQ.add(depth + 1);
            }
            if (node.right != null) {
                nodeQ.add(node.right);
                depthQ.add(depth + 1);
            }
        }
        
        return candidateVal;
    }
}
