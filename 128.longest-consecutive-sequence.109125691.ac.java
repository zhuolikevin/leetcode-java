/*
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence
 *
 * Hard (36.50%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Can you solve this problem? 🤔
 */
class UnionFind {
    int[] table;
    public UnionFind(int n) {
        table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = i;
        }
    }
    public void union(int i, int j) {
        int father1 = find(i);
        int father2 = find(j);
        if (father1 != father2) {
            table[father1] = father2;
        }
    }
    public int find(int k) {
        int father = table[k];
        while (table[father] != father) {
            father = table[father];
        }
        return father;
    }
}
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        UnionFind uf = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        
        Map<Integer, Integer> setCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int father = uf.find(i);
            setCount.put(father, setCount.getOrDefault(father, 0) + 1);
        }
        
        int maxLen = 0;
        for (int father : setCount.keySet()) {
            maxLen = Math.max(maxLen, setCount.get(father));
        }
        
        return maxLen;
    }
}
