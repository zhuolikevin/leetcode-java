/*
 * [348] Design Tic-Tac-Toe
 *
 * https://leetcode.com/problems/design-tic-tac-toe
 *
 * Medium (45.82%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["TicTacToe","move","move","move","move","move","move","move"]\n[[3],[0,0,1],[0,2,2],[2,2,1],[1,1,2],[2,0,1],[1,0,2],[2,1,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class TicTacToe {
    private int[][] countRow;
    private int[][] countCol;
    private int[][] countDia;
    private int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.countRow = new int[2][n];
        this.countCol = new int[2][n];
        this.countDia = new int[2][2];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int otherPlayer = (player - 1 + 1) % 2;
        countRow[player - 1][row]++;
        countCol[player - 1][col]++;
        if (row == col) {
            countDia[player - 1][0]++;
        }
        if (row == n - col - 1) {
            countDia[player - 1][1]++;
        }
        if (countRow[player - 1][row] == n ||
            countCol[player - 1][col] == n ||
            countDia[player - 1][0] == n ||
            countDia[player - 1][1] == n) {
            return player;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
