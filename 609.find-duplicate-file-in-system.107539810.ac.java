/*
 * [609] Find Duplicate File in System
 *
 * https://leetcode.com/problems/find-duplicate-file-in-system
 *
 * Medium (52.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]'
 *
 * Can you solve this problem? 🤔
 */
import java.util.regex.*;
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path : paths) {
            String[] parts = path.split(" ");
            String route = parts[0];
            for (int i = 1; i < parts.length; i++) {
                Pattern pattern = Pattern.compile("^(.+)\\(([a-zA-Z0-9]+)\\)$");
                Matcher matcher = pattern.matcher(parts[i]);
                if (matcher.find()) {
                    String filename = matcher.group(1);
                    String content = matcher.group(2);
                    List<String> pathList = map.getOrDefault(content, new ArrayList<>());
                    pathList.add(route + "/" + filename);
                    map.put(content, pathList); 
                }
            }
        }
        
        for (String content : map.keySet()) {
            List<String> pathList = map.get(content);
            if (pathList.size() > 1) {
                res.add(pathList);
            }
        }
        
        return res;
    }
}
