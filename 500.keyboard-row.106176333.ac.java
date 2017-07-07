/*
 * [500] Keyboard Row
 *
 * https://leetcode.com/problems/keyboard-row
 *
 * Easy (60.00%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String[] findWords(String[] words) {
        HashSet<Character> rowSet1 = new HashSet<>();
        HashSet<Character> rowSet2 = new HashSet<>();
        HashSet<Character> rowSet3 = new HashSet<>();
        
        rowSet1.add('q');
        rowSet1.add('w');
        rowSet1.add('e');
        rowSet1.add('r');
        rowSet1.add('t');
        rowSet1.add('y');
        rowSet1.add('u');
        rowSet1.add('i');
        rowSet1.add('o');
        rowSet1.add('p');
        
        rowSet2.add('a');
        rowSet2.add('s');
        rowSet2.add('d');
        rowSet2.add('f');
        rowSet2.add('g');
        rowSet2.add('h');
        rowSet2.add('j');
        rowSet2.add('k');
        rowSet2.add('l');
        
        rowSet3.add('z');
        rowSet3.add('x');
        rowSet3.add('c');
        rowSet3.add('v');
        rowSet3.add('b');
        rowSet3.add('n');
        rowSet3.add('m');
        
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            char[] charArr = word.toLowerCase().toCharArray();
            
            char first = charArr[0];
            int i = 1;
            if (rowSet1.contains(first)) {
                while (i < charArr.length) {
                    if (!rowSet1.contains(charArr[i])) break;
                    i++;
                }
                if (i == charArr.length) { sb.append(word + " "); }
            } else if (rowSet2.contains(first)) {
                while (i < charArr.length) {
                    if (!rowSet2.contains(charArr[i])) break;
                    i++;
                }
                if (i == charArr.length) { sb.append(word + " "); }
            } else if (rowSet3.contains(first)) {
                while (i < charArr.length) {
                    if (!rowSet3.contains(charArr[i])) break;
                    i++;
                }
                if (i == charArr.length) { sb.append(word + " "); }
            }
        }
        String result = sb.toString().trim();
        if (result.equals("")) {
            return new String[0];
        } else {
            return result.split(" ");
        }
    }
}
