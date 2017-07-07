/*
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 *
 * Easy (33.47%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) { return res; }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int len = p.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (!map.containsKey(s.charAt(right))) {
                right++;
                while (left < right) {
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);    
                    }
                    left++;
                }
            } else {
                int count = map.get(s.charAt(right));
                if (count > 0) {
                    map.put(s.charAt(right), count - 1);
                    right++;
                    if (right - left == len) {
                        res.add(left);
                        map.put(s.charAt(left), 1);
                        left++;
                    }
                } else {
                    while (s.charAt(left) != s.charAt(right)) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        left++;
                    }
                    if (left != right) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        left++; 
                    }
                }
            }
        }
        return res;
    }
}
