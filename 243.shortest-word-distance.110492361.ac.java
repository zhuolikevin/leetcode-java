/*
 * [243] Shortest Word Distance
 *
 * https://leetcode.com/problems/shortest-word-distance
 *
 * Easy (52.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["a","b"]\n"a"\n"b"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return -1;
        }
        
        Map<String, Integer> map = new HashMap<>();
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                map.put(word1, i);
                if (map.containsKey(word2)) {
                    shortest = Math.min(shortest, i - map.get(word2));
                }
            } else if (words[i].equals(word2)) {
                map.put(word2, i);
                if (map.containsKey(word1)) {
                    shortest = Math.min(shortest, i - map.get(word1));
                }
            }
        }
        
        return shortest;
    }
}
