/*
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii
 *
 * Medium (39.36%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        
        int[][] res = new int[n][n];
        
        int i = 0;
        int j = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int index = 0;
        int count = 1;
        while (count <= n * n) {
            res[i][j] = count;
            count++;
            int x = i + dirs[index][0];
            int y = j + dirs[index][1];
            if (x < 0 || x >= n || y < 0 || y >= n || res[x][y] != 0) {
                index = (index + 1) % 4;
                x = i + dirs[index][0];
                y = j + dirs[index][1];
            }
            i = x;
            j = y;
        }
        
        return res;
    }
}
