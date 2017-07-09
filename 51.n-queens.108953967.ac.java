/*
 * [51] N-Queens
 *
 * https://leetcode.com/problems/n-queens
 *
 * Hard (30.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<String> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            matrix.add(sb.toString());
        }
        
        List<List<String>> res = new ArrayList<>();
        helper(res, 0, n, matrix);
        return res;
    }
    
    private void helper(List<List<String>> res, int row, int n, List<String> curMatrix) {
        if (row == n - 1) {
            for (int col = 0; col < n; col++) {
                if (canPlace(row, col, n, curMatrix)) {
                    List<String> newSolu = new ArrayList<>(curMatrix);
                    char[] curRow = curMatrix.get(row).toCharArray();
                    curRow[col] = 'Q';
                    newSolu.set(row, new String(curRow));
                    res.add(newSolu);
                }
            }
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (canPlace(row, col, n, curMatrix)) {
                char[] curRow = curMatrix.get(row).toCharArray();
                curRow[col] = 'Q';
                curMatrix.set(row, new String(curRow));
                
                helper(res, row + 1, n, curMatrix);
                
                curRow[col] = '.';
                curMatrix.set(row, new String(curRow));
            }
        }
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
