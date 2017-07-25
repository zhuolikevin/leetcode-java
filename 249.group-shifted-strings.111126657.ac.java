/*
 * [249] Group Shifted Strings
 *
 * https://leetcode.com/problems/group-shifted-strings
 *
 * Medium (41.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abc","bcd","acef","xyz","az","ba","a","z"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String string : strings) {
            String key = convert(string);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            List<String> list = map.get(key);
            list.add(string);
            map.put(key, list);
        }
        
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    
    private String convert(String str) {
        if (str.length() == 0) {
            return "";
        }
        char[] chars = str.toCharArray();
        int diff = chars[0] - 'a';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' < diff) {
                chars[i] = (char)(chars[i] + 26 - diff);
            } else {
                chars[i] = (char)(chars[i] - diff);
            }
        }
        return new String(chars);
    }
}
