/*
 * [422] Valid Word Square
 *
 * https://leetcode.com/problems/valid-word-square
 *
 * Easy (36.15%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abcd","bnrt","crmy","dtye"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words.size() != words.get(0).length()) {
            return false;
        }
        
        int n = words.size();
        for (String word : words) {
            if (word.length() > n) {
                return false;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j >= words.get(i).length() && i >= words.get(j).length()) {
                    continue;
                } else if (j >= words.get(i).length() || i >= words.get(j).length()) {
                    return false;
                } else if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
