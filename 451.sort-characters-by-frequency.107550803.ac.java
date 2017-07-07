/*
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency
 *
 * Medium (50.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"tree"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(i)));
        }
        
        List<Character>[] buckets = new List[maxCount];
        for (char c : map.keySet()) {
            int index = map.get(c) - 1;
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<Character>();
            }
            buckets[index].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i + 1; j++) {
                        sb.append(c);
                    }
                }    
            }
        }
        return sb.toString();
    }
}
