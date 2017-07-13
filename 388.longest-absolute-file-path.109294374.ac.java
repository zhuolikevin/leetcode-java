/*
 * [388] Longest Absolute File Path
 *
 * https://leetcode.com/problems/longest-absolute-file-path
 *
 * Medium (36.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        
        String[] parts = input.split("\\\n");
        Stack<Integer> stack = new Stack<>();
        
        int maxLen = 0;
        for (String part : parts) {
            int level = part.lastIndexOf("\t") + 1;
            while (stack.size() >= level + 1) {
                stack.pop();
            }
            int prevLen = stack.isEmpty() ? -1 : stack.peek();
            int newLen = prevLen + 1 + part.substring(level).length();
            stack.push(newLen);
            if (part.contains(".")) {
                maxLen = Math.max(maxLen, newLen);
            }
        }
        
        return maxLen;
    }
}
