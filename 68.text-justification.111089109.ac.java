/*
 * [68] Text Justification
 *
 * https://leetcode.com/problems/text-justification
 *
 * Hard (18.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[""]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (maxWidth == 0) {
            res.add("");
            return res;
        }
        if (words == null || words.length == 0) {
            char[] chars = new char[maxWidth];
            Arrays.fill(chars, ' ');
            res.add(new String(chars));
            return res;
        }
        
        int left = 0;
        int right = 0;
        while (right < words.length) {
            int len = 0;
            while (right < words.length && len + words[right].length() <= maxWidth) {
                len += words[right].length() + 1;
                right++;
            }
            
            res.add(formLine(words, left, right, len - 1, maxWidth, right == words.length));
            left = right;
        }
        
        return res;
    }
    
    private String formLine(String[] words, int left, int right, int len, int maxWidth, boolean isLastLine) {
        StringBuilder sb = new StringBuilder();
        int gapCount = right - left - 1;
        if (!isLastLine && gapCount != 0) {
            int totalWordsLen = len - gapCount;
            int totalGapLen = maxWidth - totalWordsLen;
            int shortGapLen = totalGapLen / gapCount;
            int longGapCount = totalGapLen % gapCount;
            for (int i = left; i < right - 1; i++) {
                sb.append(words[i]);
                for (int j = 0; j < shortGapLen; j++) {
                    sb.append(' ');
                }
                if (longGapCount > 0) {
                    sb.append(' ');
                    longGapCount--;
                }
            }
            sb.append(words[right - 1]);
        } else {
            for (int i = left; i < right - 1; i++) {
                sb.append(words[i]).append(' ');
            }
            sb.append(words[right - 1]);
            while (sb.length() < maxWidth) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
