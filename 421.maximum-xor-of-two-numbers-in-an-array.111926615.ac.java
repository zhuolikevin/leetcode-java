/*
 * [421] Maximum XOR of Two Numbers in an Array
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array
 *
 * Medium (45.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * Can you solve this problem? 🤔
 */
class TrieNode {
    TrieNode[] children;
    TrieNode() {
        children = new TrieNode[2];
    }
}

public class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        TrieNode root = new TrieNode();
        
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new TrieNode();
                }
                cur = cur.children[bit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            TrieNode cur = root;
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (cur.children[bit ^ 1] != null) {
                    sum += (1 << i);
                    cur = cur.children[bit ^ 1];
                } else {
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
