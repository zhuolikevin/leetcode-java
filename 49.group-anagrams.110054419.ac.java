/*
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams
 *
 * Medium (34.19%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            List<String> list = !map.containsKey(newStr) ? new ArrayList<>() : map.get(newStr);
            list.add(str);
            map.put(newStr, list);
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        
        return res;
    }
}
