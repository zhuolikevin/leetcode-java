/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 *
 * Medium (34.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0 || digits.indexOf("1") != -1 || digits.indexOf("0") != -1) {
            return res;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        
        search(res, digits, 0, "", map);
        return res;
    }
    
    private void search(List<String> res, String digits, int index, String prev, Map<Character, char[]> map) {
        if (index == digits.length()) {
            res.add(prev);
            return;
        }
        char[] letters = map.get(digits.charAt(index));
        for (char letter : letters) {
            search(res, digits, index + 1, prev + letter, map);
        }
    }
}
