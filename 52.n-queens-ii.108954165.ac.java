/*
 * [52] N-Queens II
 *
 * https://leetcode.com/problems/n-queens-ii
 *
 * Hard (44.39%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int totalNQueens(int n) {
        List<String> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            matrix.add(sb.toString());
        }
        
        return helper(0, n, matrix);
    }
    
    private int helper(int row, int n, List<String> curMatrix) {
        int count = 0;
        if (row == n - 1) {
            for (int col = 0; col < n; col++) {
                if (canPlace(row, col, n, curMatrix)) {
                    count++;
                }
            }
            return count;
        }
        
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, n, curMatrix)) {
                char[] curRow = curMatrix.get(row).toCharArray();
                curRow[col] = 'Q';
                curMatrix.set(row, new String(curRow));
                
                count += helper(row + 1, n, curMatrix);
                
                curRow[col] = '.';
                curMatrix.set(row, new String(curRow));
            }
        }
        
        return count;
    }
    
    private boolean canPlace(int row, int col, int n, List<String> curMatrix) {
        for (int i = row - 1; i >= 0; i--) {
            if (curMatrix.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (curMatrix.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (curMatrix.get(i).charAt(j) == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}
