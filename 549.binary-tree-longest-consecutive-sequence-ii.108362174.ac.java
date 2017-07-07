/*
 * [549] Binary Tree Longest Consecutive Sequence II
 *
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii
 *
 * Medium (39.45%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4]'
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
    private int longest = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        
        int incCount = 1;
        int decCount = 1;
        if (node.left != null) {
            int[] leftRes = helper(node.left);
            if (node.val == node.left.val + 1) {
                decCount = Math.max(decCount, leftRes[1] + 1);
            } else if (node.val == node.left.val - 1) {
                incCount = Math.max(incCount, leftRes[0] + 1);
            }
        }
        if (node.right != null) {
            int[] rightRes = helper(node.right);
            if (node.val + 1 == node.right.val) {
                incCount = Math.max(incCount, rightRes[0] + 1);
            } else if (node.val - 1 == node.right.val) {
                decCount = Math.max(decCount, rightRes[1] + 1);
            }
        }
        
        longest = Math.max(longest, incCount + decCount - 1);
        return new int[] { incCount, decCount };
    }
}
