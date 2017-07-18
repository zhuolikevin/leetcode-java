/*
 * [270] Closest Binary Search Tree Value
 *
 * https://leetcode.com/problems/closest-binary-search-tree-value
 *
 * Easy (39.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n4.428571'
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
    public int closestValue(TreeNode root, double target) {
        Integer smaller = null;
        Integer larger = null;
        TreeNode curNode = root;
        while (curNode != null) {
            if (curNode.val == target) {
                return curNode.val;
            } else if (curNode.val > target) {
                larger = curNode.val;
                curNode = curNode.left;
            } else {
                smaller = curNode.val;
                curNode = curNode.right;
            }
        }
        if (smaller == null) {
            return larger;
        }
        if (larger == null) {
            return smaller;
        }
        return larger - target < target - smaller ? larger : smaller;
    }
}
