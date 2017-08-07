/*
 * [653] Two Sum IV - Input is a BST
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 *
 * Easy (51.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
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
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        Set<Integer> set = new HashSet<>();
        
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (set.contains(k - cur.val)) {
                    return true;
                }
                set.add(cur.val);
                cur = cur.right;
            }
        }
        
        return false;
    }
}
