/*
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree
 *
 * Easy (37.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,null,2,2]'
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
    public int[] findMode(TreeNode root) {
        if (root == null) { return new int[0]; }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        int count = 0;
        int maxCount = 0;
        Integer curNum = null;
        
        TreeNode curNode = root;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = stack.pop();
                if (curNum == null || curNum == curNode.val) {
                    curNum = curNode.val;
                    count++;
                } else {
                    if (count >= maxCount) {
                        if (count > maxCount) { res.clear(); }
                        res.add(curNum);
                        maxCount = count;
                    }
                    curNum = curNode.val;
                    count = 1;
                }
                curNode = curNode.right;
            }
        }
        
        if (count >= maxCount) {
            if (count > maxCount) { res.clear(); }
            res.add(curNum);
            maxCount = count;
        }
        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
