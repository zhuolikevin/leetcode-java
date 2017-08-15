/*
 * [157] Read N Characters Given Read4
 *
 * https://leetcode.com/problems/read-n-characters-given-read4
 *
 * Easy (28.96%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n0'
 *
 * Can you solve this problem? 🤔
 */
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char[] temp = new char[4];
        int count = 0;
        while (count < n && !eof) {
            int actualRead = read4(temp);
            if (actualRead < 4) {
                eof = true;
            }
            int actualNeed = Math.min(actualRead, n - count);
            for (int i = 0; i < actualNeed; i++) {
                buf[count] = temp[i];
                count++;
            }
        }
        return count;
    }
}
