/*
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii
 *
 * Medium (43.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,2,3,null,3,null,1]'
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
class ReturnType {
    int robIt;
    int notRobIt;
    ReturnType(int robIt, int notRobIt) {
        this.robIt = robIt;
        this.notRobIt = notRobIt;
    }
}
public class Solution {
    public int rob(TreeNode root) {
        ReturnType res = helper(root);
        return Math.max(res.robIt, res.notRobIt);
    }
    private ReturnType helper(TreeNode node) {
        ReturnType res = new ReturnType(0, 0);
        if (node == null) { return res; }
        
        ReturnType left = helper(node.left);
        ReturnType right = helper(node.right);
        int notRobIt = Math.max(left.robIt, left.notRobIt) + Math.max(right.robIt, right.notRobIt);
        int robIt = node.val + left.notRobIt + right.notRobIt;
        return new ReturnType(robIt, notRobIt);
    }
}
