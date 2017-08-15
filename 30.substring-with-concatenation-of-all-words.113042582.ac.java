/*
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 *
 * Hard (21.92%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        int count = words.length;
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - len * count; i++) {
            String nextWord = s.substring(i, i + len);
            if (map.containsKey(nextWord)) {
                int tempCount = count;
                Map<String, Integer> tempMap = new HashMap<>(map);
                for (int left = i; left < i + len * count; left += len) {
                    String word = s.substring(left, left + len);
                    if (!tempMap.containsKey(word) || tempMap.get(word) == 0) {
                        break;
                    } 
                    tempMap.put(word, tempMap.get(word) - 1);
                    tempCount--;
                }
                if (tempCount == 0) {
                    res.add(i);
                }
            }
        }
        
        return res;
    }
}
