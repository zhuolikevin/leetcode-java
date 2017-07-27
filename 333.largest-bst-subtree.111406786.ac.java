/*
 * [333] Largest BST Subtree
 *
 * https://leetcode.com/problems/largest-bst-subtree
 *
 * Medium (30.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[10,5,15,1,8,null,7]'
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
    boolean isBST;
    int min;
    int max;
    int size;
    ReturnType(boolean isBST, int min, int max, int size) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.size = size;
    }
}
public class Solution {
    private int maxSize;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        maxSize = 1;
        traverse(root);
        return maxSize;
    }
    
    private ReturnType traverse(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new ReturnType(true, root.val, root.val, 1);
        }
        
        ReturnType leftReturn = root.left != null
            ? traverse(root.left)
            : new ReturnType(true, root.val, Integer.MIN_VALUE, 0);
        ReturnType rightReturn = root.right != null
            ? traverse(root.right)
            : new ReturnType(true, Integer.MAX_VALUE, root.val, 0);
        
        int size = leftReturn.size + 1 + rightReturn.size;
        if (leftReturn.isBST && rightReturn.isBST && root.val > leftReturn.max && root.val < rightReturn.min) {
            maxSize = Math.max(maxSize, size);
            return new ReturnType(true, leftReturn.min, rightReturn.max, size);
        }
        
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            min = Math.min(min, leftReturn.min);
            max = Math.max(max, leftReturn.max);
        }
        if (root.right != null) {
            min = Math.min(min, rightReturn.min);
            max = Math.max(max, rightReturn.max);
        }
        return new ReturnType(false, min, max, size);
    }
}
