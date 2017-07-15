/*
 * [316] Remove Duplicate Letters
 *
 * https://leetcode.com/problems/remove-duplicate-letters
 *
 * Hard (29.37%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"bcabc"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            freq[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            freq[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            
            while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                char lastC = stack.pop();
                visited[lastC - 'a'] = false;
            }
            
            stack.push(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
