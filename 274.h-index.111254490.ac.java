/*
 * [274] H-Index
 *
 * https://leetcode.com/problems/h-index
 *
 * Medium (33.02%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - i - 1] > i) {
            i++;
        }
        return i;
    }
}
