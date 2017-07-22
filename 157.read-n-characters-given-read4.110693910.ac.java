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
        int count = 0;
        char[] temp = new char[4];
        
        while (!eof && count < n) {
            int actualRead = read4(temp);
            eof = actualRead < 4;
            int need = Math.min(actualRead, n - count);
            for (int i = 0; i < need; i++) {
                buf[count] = temp[i];
                count++;
            }
        }
        
        return count;
    }
}
