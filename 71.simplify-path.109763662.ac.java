/*
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path
 *
 * Medium (25.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"/"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        String[] res = new String[stack.size()];
        int i = res.length - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }
        
        return "/" + String.join("/", res);
    }
}
