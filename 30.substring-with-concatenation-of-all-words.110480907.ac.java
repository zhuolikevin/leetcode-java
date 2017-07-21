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
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return res;
        }
        
        int len = words[0].length();
        if (s.length() < len * words.length) {
            return res;
        }
        
        int count = 0;
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
            count++;
        }
        
        for (int left = 0; left + len * words.length <= s.length(); left++) {
            Map<String, Integer> temp = new HashMap<>(dict);
            int curCount = count;
            for (int right = left + len; right <= left + len * words.length; right += len) {
                String nextWord = s.substring(right - len, right);
                if (temp.containsKey(nextWord) && temp.get(nextWord) > 0) {
                    temp.put(nextWord, temp.get(nextWord) - 1);
                    curCount--;
                } else {
                    break;
                }
            }
            if (curCount == 0) {
                res.add(left);
            }
        }
        
        return res;
    }
}
