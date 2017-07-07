/*
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word
 *
 * Easy (31.73%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') { i--; }
        if (i < 0) { return 0; }
        
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        return count;
    }
}
