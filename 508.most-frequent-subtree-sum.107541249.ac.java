/*
 * [508] Most Frequent Subtree Sum
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum
 *
 * Medium (52.10%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,2,-3]'
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
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);
        List<Integer> res = new ArrayList<>();
        int maxFreq = 0;
        for (int sum : map.keySet()) {
            if (map.get(sum) > maxFreq) {
                res.clear();
                res.add(sum);
                maxFreq = map.get(sum);
            } else if (map.get(sum) == maxFreq) {
                res.add(sum);
            }
        }
        
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
    private int traverse(TreeNode node) {
        if (node == null) { return 0; }
        int leftSum = traverse(node.left);
        int rightSum = traverse(node.right);
        int sum = node.val + leftSum + rightSum;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
