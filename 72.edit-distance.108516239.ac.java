/*
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance
 *
 * Hard (31.46%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '""\n""'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int[][] steps = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            steps[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            steps[0][j] = j;
        }
        
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    steps[i][j] = steps[i - 1][j - 1];
                } else  {
                    steps[i][j] = Math.min(steps[i - 1][j - 1], Math.min(steps[i - 1][j], steps[i][j - 1])) + 1;
                }
            }
        }
        
        return steps[word1.length()][word2.length()];
    }
}
