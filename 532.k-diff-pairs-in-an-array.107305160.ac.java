/*
 * [532] K-diff Pairs in an Array
 *
 * https://leetcode.com/problems/k-diff-pairs-in-an-array
 *
 * Easy (28.08%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0 || k < 0) { return 0; }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) { count++; }
            } else {
                if (map.containsKey(key + k)) { count++; }
            }
        }
        return count;
    }
}
