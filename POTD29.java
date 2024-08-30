//The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
// Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        solveNQueens(0, board, result, n);
        return result;
    }

    private void solveNQueens(int col, int[] board, ArrayList<ArrayList<Integer>> result, int n) {
        if (col == n) {
            result.add(createSolution(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row, n)) {
                board[col] = row + 1; // Place the queen at row (1-indexed)
                solveNQueens(col + 1, board, result, n);
                board[col] = 0; // Backtrack
            }
        }
    }

    private boolean isSafe(int[] board, int col, int row, int n) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row + 1 ||
                    Math.abs(board[i] - (row + 1)) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> createSolution(int[] board, int n) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(board[i]);
        }
        return solution;
    }
}