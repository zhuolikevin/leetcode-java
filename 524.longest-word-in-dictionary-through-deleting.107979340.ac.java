/*
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting
 *
 * Medium (41.87%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexList = map.get(s.charAt(i));
            if (indexList == null) { indexList = new ArrayList<Integer>(); }
            indexList.add(i);
            map.put(s.charAt(i), indexList);
        }
        Collections.sort(d);
        return helper(map, d);
    }
    
    private String helper(Map<Character, List<Integer>> map, List<String> d) {
        String res = "";
        for (String str : d) {
            if (str.length() <= res.length()) { continue; }
            boolean flag = true;
            int lastIndex = -1;
            for (int i = 0; i < str.length(); i++) {
                List<Integer> indexList = map.get(str.charAt(i));
                if (indexList == null) {
                    flag = false;
                    break;
                }
                int j = 0;
                while (j < indexList.size() && indexList.get(j) <= lastIndex) { j++; }
                if (j == indexList.size()) {
                    flag = false;
                    break;
                } else {
                    lastIndex = indexList.get(j);
                }
            }
            if (flag) { res = str; }
        }
        return res;
    }
}
