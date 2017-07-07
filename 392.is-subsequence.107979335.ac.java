/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence
 *
 * Medium (44.33%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            List<Integer> indexList = map.get(t.charAt(i));
            if (indexList == null) { indexList = new ArrayList<Integer>(); }
            indexList.add(i);
            map.put(t.charAt(i), indexList);
        }
        int lastIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexList = map.get(s.charAt(i));
            if (indexList == null) {
                return false;
            }
            int j = 0;
            while (j < indexList.size() && indexList.get(j) <= lastIndex) { j++; }
            if (j == indexList.size()) {
                return false;
            } else {
                lastIndex = indexList.get(j);
            }
        }
        return true;
    }
}
