/*
 * [314] Binary Tree Vertical Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal
 *
 * Medium (36.37%)
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int leftMostCol = 0;
        int rightMostCol = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        queue.offer(root);
        colQ.offer(0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int col = colQ.poll();
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                    leftMostCol = Math.min(leftMostCol, col);
                    rightMostCol = Math.max(rightMostCol, col);
                }
                map.get(col).add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                    colQ.offer(col - 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    colQ.offer(col + 1);
                }
            }
        }
        
        for (int i = leftMostCol; i <= rightMostCol; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}
