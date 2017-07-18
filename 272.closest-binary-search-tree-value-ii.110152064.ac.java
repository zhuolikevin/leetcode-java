/*
 * [272] Closest Binary Search Tree Value II
 *
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii
 *
 * Hard (38.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n0.000000\n1'
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        initStacks(root, pred, succ, target);
        while (k > 0) {
            if (succ.isEmpty() || !pred.isEmpty() && target - pred.peek().val < succ.peek().val - target) {
                res.add(pred.peek().val);
                getNextPred(pred);
            } else {
                res.add(succ.peek().val);
                getNextSucc(succ);
            }
            k--;
        }
        return res;
    }
    
    private void initStacks(TreeNode root, Stack<TreeNode> pred, Stack<TreeNode> succ, double target) {
        while (root != null) {
            if (root.val >= target) {
                succ.push(root);
                root = root.left;
            } else {
                pred.push(root);
                root = root.right;
            }
        }
    }
    private void getNextPred(Stack<TreeNode> pred) {
        TreeNode node = pred.pop();
        if (node.left != null) {
            pred.push(node.left);
            while (pred.peek().right != null) {
                pred.push(pred.peek().right);
            }
        }
    }
    private void getNextSucc(Stack<TreeNode> succ) {
        TreeNode node = succ.pop();
        if (node.right != null) {
            succ.push(node.right);
            while (succ.peek().left != null) {
                succ.push(succ.peek().left);
            }
        }
    }
}
