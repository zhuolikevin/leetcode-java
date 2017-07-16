/*
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 *
 * Medium (34.20%)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> thisLevel = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reverse) {
                    reverseStack.push(node.val);
                } else {
                    thisLevel.add(node.val);
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (reverse) {
                while (!reverseStack.isEmpty()) {
                    thisLevel.add(reverseStack.pop());
                }
            }
            res.add(thisLevel);
            reverse = !reverse;
        }
        
        return res;
    }
}
