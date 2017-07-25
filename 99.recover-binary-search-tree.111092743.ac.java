/*
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree
 *
 * Hard (29.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[0,1]'
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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode prevNode = null;
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                if (prevNode != null)  {
                    if (curNode.val < prevNode.val) {
                        if (firstNode == null) {
                            firstNode = prevNode;
                            secondNode = curNode;
                        } else {
                            secondNode = curNode;
                        }
                    }
                }
                prevNode = curNode;
                curNode = curNode.right;
            }
        }
        
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }
}
