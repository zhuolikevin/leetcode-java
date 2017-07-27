/*
 * [320] Generalized Abbreviation
 *
 * https://leetcode.com/problems/generalized-abbreviation
 *
 * Medium (44.71%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"word"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        
        helper(res, word, 0, "");
        return res;
    }
    
    private void helper(List<String> res, String word, int start, String path) {
        if (start == word.length()) {
            res.add(path);
            return;
        }
        
        char letter = word.charAt(start);
        helper(res, word, start + 1, path + letter);
        helper(res, word, start + 1, form(path, 1));
    }
    
    private String form(String path, int i) {
        int j = path.length() - 1;
        while (j >= 0 && Character.isDigit(path.charAt(j))) {
            j--;
        }
        
        int formerNum = j == path.length() - 1 ? 0 : Integer.parseInt(path.substring(j + 1));
        return path.substring(0, j + 1) + String.valueOf(formerNum + i);
    }
}
