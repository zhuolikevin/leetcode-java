/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees
 *
 * Medium (25.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1,1]'
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        serialize(res, root, map);
        return res;
    }
    
    private String serialize(List<TreeNode> res, TreeNode root, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + serialize(res, root.left, map) + "," + serialize(res, root.right, map);
        if (map.containsKey(serial) && map.get(serial) == 1) {
            res.add(root);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
