/*
 * [108] Convert Sorted Array to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 *
 * Easy (41.80%)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) { return null; }
        TreeNode root = new TreeNode(0);
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> leftIndexStack = new Stack<>();
        Stack<Integer> rightIndexStack = new Stack<>();
        
        nodeStack.push(root);
        leftIndexStack.push(0);
        rightIndexStack.push(nums.length - 1);
        
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left) / 2;
            node.val = nums[mid];
            if (left < mid) {
                node.left = new TreeNode(0);
                nodeStack.push(node.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid - 1);
            }
            if (mid < right) {
                node.right = new TreeNode(0);
                nodeStack.push(node.right);
                leftIndexStack.push(mid + 1);
                rightIndexStack.push(right);
            }
        }
        
        return root;
    }
}
