/*
 * [158] Read N Characters Given Read4 II - Call multiple times
 *
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times
 *
 * Hard (24.16%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n[read(0)]'
 *
 * Can you solve this problem? 🤔
 */
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private Queue<Character> lastRemain = new LinkedList<>();
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= lastRemain.size()) {
            for (int i = 0; i < n; i++) {
                buf[i] = lastRemain.poll();
            }
            return n;
        }
     
        boolean eof = false;
        int count = 0;
        char[] temp = new char[4];
        
        while (!lastRemain.isEmpty()) {
            buf[count] = lastRemain.poll();
            count++;
        }
        
        while (!eof && count < n) {
            int actualRead = read4(temp);
            eof = actualRead < 4;
            int need = Math.min(actualRead, n - count);
            int i = 0;
            while (i < need) {
                buf[count] = temp[i];
                count++;
                i++;
            }
            while (i < actualRead) {
                lastRemain.offer(temp[i]);
                i++;
            }
        }
        return count;
    }
}
