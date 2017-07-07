/*
 * [606] Construct String from Binary Tree
 *
 * https://leetcode.com/problems/construct-string-from-binary-tree
 *
 * Easy (51.90%)
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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(t.val));
        if (t.left == null && t.right != null) {
            return sb.append("()(" + tree2str(t.right) + ")").toString();
        } else if (t.left == null && t.right == null) {
            return sb.toString();
        } else {
            sb.append("(" + tree2str(t.left) + ")");
            if (t.right != null) sb.append("(" + tree2str(t.right) + ")");
            return sb.toString();
        }
    }
}
