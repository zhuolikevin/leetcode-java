/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii
 *
 * Easy (39.57%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
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
    private Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        map.put(0, 1);
        if (root == null) { return 0; }
        return helper(root, 0, sum);
    }
    private int helper(TreeNode node, int curSum, int target) {
        if (node == null) { return 0; }
        
        curSum = curSum + node.val;
        int res = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        res += helper(node.left, curSum, target) + helper(node.right, curSum, target);
        map.put(curSum, map.get(curSum) - 1); // backtrack, remove value at this node
        return res;
    }
}
