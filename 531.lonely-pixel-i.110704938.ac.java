/*
 * [531] Lonely Pixel I
 *
 * https://leetcode.com/problems/lonely-pixel-i
 *
 * Medium (53.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["WWB","WBW","BWW"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        
        int m = picture.length;
        int n = picture[0].length;
        
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    continue;
                }
                if (picture[i][j] == 'B') {
                    if (search(picture, i, j, row, col)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean search(char[][] picture, int i, int j, boolean[] row, boolean[] col) {
        int m = picture.length;
        int n = picture[0].length;
        
        boolean lonely = true;
        for (int x = 0; x < m; x++) {
            if (x == i) {
                continue;
            }
            if (picture[x][j] == 'B') {
                row[x] = true;
                lonely = false;
            }
        }
        for (int y = 0; y < n; y++) {
            if (y == j) {
                continue;
            }
            if (picture[i][y] == 'B') {
                col[y] = true;
                lonely = false;
            }
        }
        
        return lonely;
    }
}
