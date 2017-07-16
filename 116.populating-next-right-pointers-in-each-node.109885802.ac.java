/*
 * [116] Populating Next Right Pointers in Each Node
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 *
 * Medium (36.93%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '{}'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode prev = null;
            
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (prev == null) {
                    prev = node;
                } else {
                    prev.next = node;
                    prev = prev.next;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            prev.next = null;
        }
    }
}
