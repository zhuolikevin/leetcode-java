/*
 * [533] Lonely Pixel II
 *
 * https://leetcode.com/problems/lonely-pixel-ii
 *
 * Medium (42.49%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["WBWBBW","WBWBBW","WBWBBW","WWBWBW"]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        
        int m = picture.length;
        int n = picture[0].length;
        
        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[n];
        
        for (int i = 0; i < m; i++) {
            String key = scanRow(picture, i, N, colCount);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < n; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
    
    private String scanRow(char[][] picture, int row, int target, int[] colCount) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        
        return rowCount == target ? sb.toString() : "";
    }
}
