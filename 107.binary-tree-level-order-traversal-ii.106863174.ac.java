/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 *
 * Easy (39.67%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,9,20,null,null,15,7]'
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        
        if (root == null) { return result; }
        
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        nodeQ.add(root);
        levelQ.add(1);
        int curLevel = 1;
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            int level = levelQ.poll();
            if (node == null) { continue; }
            
            if (level != curLevel) {
                // New level, save last level results
                result.add(0, temp);
                curLevel = level;
                temp = new ArrayList<>();
            }
            temp.add(node.val);
            nodeQ.add(node.left);
            nodeQ.add(node.right);
            levelQ.add(level + 1);
            levelQ.add(level + 1);
        }
        result.add(0, temp);
        return result;
    }
}
