/*
 * [449] Serialize and Deserialize BST
 *
 * https://leetcode.com/problems/serialize-and-deserialize-bst
 *
 * Medium (42.28%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,1,3]'
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) { continue; }
            sb.append(node.val + ",");
            stack.push(node.right);
            stack.push(node.left);
        }
        String res = sb.toString();
        return res.length() > 0 ? res.substring(0, res.length() - 1) : res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) { return null; }
        String[] numbers = data.split(",");
        List<Integer> dataNums = new ArrayList<>();
        for (String number : numbers) {
            dataNums.add(Integer.valueOf(number));
        }
        return helper(dataNums);
    }
    
    private TreeNode helper(List<Integer> dataNums) {
        if (dataNums.size() == 0) { return null; }
        TreeNode root = new TreeNode(dataNums.get(0));
        int i = 1;
        while (i < dataNums.size() && dataNums.get(i) < dataNums.get(0)) { i++; }
        root.left = helper(dataNums.subList(1, i));
        root.right = helper(dataNums.subList(i, dataNums.size()));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
