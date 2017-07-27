/*
 * [331] Verify Preorder Serialization of a Binary Tree
 *
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree
 *
 * Medium (36.12%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"9,3,4,#,#,1,#,#,2,#,6,#,#"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0 || preorder.equals("#")) {
            return true;
        }
        
        Stack<String> stack = new Stack<>();
        String[] parts = preorder.split(",");
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("#")) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek().equals("#")) {
                    while (!stack.isEmpty() && stack.peek().equals("#")) {
                        stack.pop();
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        stack.push("#");
                    }
                } else {
                    stack.push("#");
                }
            } else {
                if (stack.isEmpty() && i != 0) {
                    return false;
                }
                stack.push(parts[i]);
            }
        }
        
        return stack.isEmpty();
    }
}
