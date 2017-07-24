/*
 * [304] Range Sum Query 2D - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable
 *
 * Medium (24.83%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["NumMatrix","sumRegion","sumRegion","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]'
 *
 * Can you solve this problem? 🤔
 */
public class NumMatrix {
    private int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        this.sumMatrix = new int[m][n];
        this.sumMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            this.sumMatrix[i][0] = this.sumMatrix[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++) {
            this.sumMatrix[0][j] = this.sumMatrix[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                this.sumMatrix[i][j] = this.sumMatrix[i - 1][j] + this.sumMatrix[i][j - 1] - this.sumMatrix[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sumMatrix[row2][col2];
        } else if (row1 == 0) {
            return sumMatrix[row2][col2] - sumMatrix[row2][col1 - 1];
        } else if (col1 == 0) {
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2];
        } else {
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2] - sumMatrix[row2][col1 - 1] + sumMatrix[row1 - 1][col1 - 1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
