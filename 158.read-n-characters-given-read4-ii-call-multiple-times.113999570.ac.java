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
    private Queue<Character> lastTimeRemain = new LinkedList<>();
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int minCount = Math.min(n, lastTimeRemain.size());
        for (int i = 0; i < minCount; i++) {
            buf[count] = lastTimeRemain.poll();
            count++;
        }
        
        if (count == n) {
            return count;
        }
        
        boolean eof = false;
        char[] temp = new char[4];
        while (count < n && !eof) {
            int actualRead = read4(temp);
            if (actualRead < 4) {
                eof = true;
            }
            
            int remainNeed = n - count;
            if (actualRead <= remainNeed) {
                for (int i = 0; i < actualRead; i++) {
                    buf[count] = temp[i];
                    count++;
                }
            } else {
                int i = 0;
                while (i < remainNeed) {
                    buf[count] = temp[i];
                    count++;
                    i++;
                }
                while (i < actualRead) {
                    lastTimeRemain.offer(temp[i]);
                    i++;
                }
            }
            
        }
        return count;
    }
}
