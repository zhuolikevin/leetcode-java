/*
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 *
 * Easy (63.27%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,9,20,15,7]'
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        queue.offer(root);
        depthQ.offer(1);
        int lastDepth = 1;
        double levelCount = 0;
        long levelSum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = depthQ.poll();
            if (depth != lastDepth) {
                res.add((double)levelSum / levelCount);
                levelSum = 0;
                levelCount = (double)0;
                lastDepth = depth;
            }
            levelSum += node.val;
            levelCount += (double)1;
            
            if (node.left != null) {
                queue.offer(node.left);
                depthQ.offer(depth + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                depthQ.offer(depth + 1);
            }
        }
        
        res.add((double)levelSum / levelCount);
        return res;
    }
}
