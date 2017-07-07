/*
 * [389] Find the Difference
 *
 * https://leetcode.com/problems/find-the-difference
 *
 * Easy (51.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        StringBuilder sb = new StringBuilder();
        char[] chars = sb.append(s + t).toString().toCharArray();
        
        char result = chars[0];
        
        for (int i = 1; i < chars.length; i++) {
            result ^= chars[i];
        }
        
        return result;
    }
}
