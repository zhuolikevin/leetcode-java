/*
 * [250] Count Univalue Subtrees
 *
 * https://leetcode.com/problems/count-univalue-subtrees
 *
 * Medium (41.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
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
    private int count;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        count = 0;
        helper(root);
        return count;
    }
    
    private boolean helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean leftSub = root.left != null ? helper(root.left) : true;
        boolean rightSub = root.right != null ? helper(root.right) : true;
        if (leftSub && rightSub) {
            int leftVal = root.left != null ? root.left.val : root.val;
            int rightVal = root.right != null ? root.right.val : root.val;
            if (root.val == leftVal && root.val == rightVal) {
                count++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
