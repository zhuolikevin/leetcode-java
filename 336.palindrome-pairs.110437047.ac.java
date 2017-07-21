/*
 * [336] Palindrome Pairs
 *
 * https://leetcode.com/problems/palindrome-pairs
 *
 * Hard (26.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String beginStr = words[i].substring(0, j);
                String endStr = words[i].substring(j);
                if (isPalin(beginStr)) {
                    String endStrRev = new StringBuilder(endStr).reverse().toString();
                    if (map.containsKey(endStrRev) && map.get(endStrRev) != i) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(map.get(endStrRev));
                        solution.add(i);
                        res.add(solution);
                    }
                }
                if (isPalin(endStr)) {
                    String beginStrRev = new StringBuilder(beginStr).reverse().toString();
                    if (map.containsKey(beginStrRev) && map.get(beginStrRev) != i && endStr.length() != 0) {
                        List<Integer> solution = new ArrayList<>();
                        solution.add(i);
                        solution.add(map.get(beginStrRev));
                        res.add(solution);
                    }
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
