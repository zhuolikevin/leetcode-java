/*
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree
 *
 * Easy (52.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,2,13]'
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
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int prevSum = 0;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.right;
            } else {
                curNode = stack.pop();
                curNode.val += prevSum;
                prevSum = curNode.val;
                curNode = curNode.left;
            }
        }
        return root;
    }
}
