/*
 * [418] Sentence Screen Fitting
 *
 * https://leetcode.com/problems/sentence-screen-fitting
 *
 * Medium (27.53%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["hello","world"]\n2\n8'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int row = 1;
        int i = 0;
        int count = 0;
        while (row <= rows) {
            int len = 0;
            while (len + sentence[i].length() <= cols) {
                len += sentence[i].length() + 1;
                i++;
                if (i == sentence.length) {
                    count++;
                    i = 0;
                }
            }
            if (i == 0) {
                int repeat = rows / row;
                count = repeat * count;
                row = repeat * row;
            }
            row++;
        }
        
        return count;
    }
}
