/*
 * [515] Find Largest Value in Each Tree Row
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 *
 * Medium (54.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3,2,5,3,null,9]'
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) { return res; }
        
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        nodeQ.add(root);
        depthQ.add(1);
        int curDepth = 1;
        int curMax = Integer.MIN_VALUE;
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.remove();
            int depth = depthQ.remove();
            if (depth > curDepth) {
                res.add(curMax);
                curMax = Integer.MIN_VALUE;
                curDepth = depth;
            }
            curMax = Math.max(curMax, node.val);
            if (node.left != null) {
                nodeQ.add(node.left);
                depthQ.add(depth + 1);
            }
            if (node.right != null) {
                nodeQ.add(node.right);
                depthQ.add(depth + 1);
            }
        }
        res.add(curMax);
        
        return res;
    }
}
