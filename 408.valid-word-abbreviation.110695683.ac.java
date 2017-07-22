/*
 * [408] Valid Word Abbreviation
 *
 * https://leetcode.com/problems/valid-word-abbreviation
 *
 * Easy (27.90%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"internationalization"\n"i12iz4n"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) == word.charAt(i)) {
                i++;
                j++;
            } else if (Character.isDigit(abbr.charAt(j))) {
                int sum = 0;
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    sum = sum * 10 + abbr.charAt(j) - '0';
                    j++;
                }
                i += sum;
            } else {
                return false;
            }
        }
        
        return i == word.length() && j == abbr.length();
    }
}
