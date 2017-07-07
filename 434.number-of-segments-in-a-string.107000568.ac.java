/*
 * [434] Number of Segments in a String
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string
 *
 * Easy (36.72%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"Hello, my name is John"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int countSegments(String s) {
        int count = 0;
        
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') { i++; }
        if (i >= s.length()) { return 0; }
        
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') { j--; }
        
        while (i <= j) {
            if (s.charAt(i) != ' ') {
                i++;
                continue;
            }
            count++;
            while (s.charAt(i) == ' ') { i++; }
        }
        count++;
        return count;
    }
}
