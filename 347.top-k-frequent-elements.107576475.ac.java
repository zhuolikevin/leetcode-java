/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements
 *
 * Medium (47.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, map.get(num));
        }
        
        List<Integer>[] buckets = new List[maxCount];
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (buckets[count - 1] == null) {
                buckets[count - 1] = new ArrayList<Integer>();
            }
            buckets[count - 1].add(num);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> list = buckets[i];
            if (list == null) { continue; }
            int j = 0;
            while (j < list.size() && k > 0) {
                res.add(list.get(j));
                j++;
                k--;
            }
            if (k == 0) { return res; }
        }
        return res;
    }
}
