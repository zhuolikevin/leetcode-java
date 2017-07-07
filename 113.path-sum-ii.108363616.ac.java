/*
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii
 *
 * Medium (33.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
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
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> initList = new ArrayList<>();
        helper(root, sum, 0, initList);
        return res;
    }
    
    private void helper(TreeNode node, int sum, int curSum, List<Integer> curList) {
        if (node == null) {
            return;
        }
        
        List<Integer> temp = new ArrayList<>(curList);
        temp.add(node.val);
        
        if (node.left == null && node.right == null) {
            if (curSum + node.val == sum) {
                res.add(temp);
            }
            return;
        }
        
        if (node.left != null) {
            helper(node.left, sum, curSum + node.val, temp);
        }
        if (node.right != null) {
            helper(node.right, sum, curSum + node.val, temp);
        }
    }
}
