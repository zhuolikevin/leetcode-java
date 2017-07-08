/*
 * [6] ZigZag Conversion
 *
 * https://leetcode.com/problems/zigzag-conversion
 *
 * Medium (26.65%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<Character>());
        }
        int index = 0;
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            lists.get(index).add(s.charAt(i));
            if (down) {
                index++;
                if (index == numRows) {
                    index = numRows - 2;
                    down = false;
                }
            } else {
                index--;
                if (index < 0) {
                    index = 1;
                    down = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (char c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
