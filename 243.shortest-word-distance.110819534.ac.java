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
        
        int index1 = -1;
        int index2 = -1;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    shortest = Math.min(shortest, i - index2);
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    shortest = Math.min(shortest, i - index1);
                }
            }
        }
        
        return shortest;
    }
}
