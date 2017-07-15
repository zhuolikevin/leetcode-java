/*
 * [173] Binary Search Tree Iterator
 *
 * https://leetcode.com/problems/binary-search-tree-iterator
 *
 * Medium (40.98%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode curNode;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        curNode = root;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        curNode = stack.pop();
        int val = curNode.val;
        
        curNode = curNode.right;
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
        
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
