class Solution {
  public void solve(char[][] board) {
    int height = board.length, width = board[0].length;

    for (int row = 0; row < height; row++) {
      if (board[row][0] == 'O')
        capture(board, row, 0);
      if (board[row][width - 1] == 'O')
        capture(board, row, width - 1);
    }

    for (int col = 0; col < width; col++) {
      if (board[0][col] == 'O')
        capture(board, 0, col);
      if (board[height - 1][col] == 'O')
        capture(board, height - 1, col);
    }

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (board[row][col] == 'O')
          board[row][col] = 'X';
        else if (board[row][col] == 'T')
          board[row][col] = 'O';
      }
    }
  }

  private void capture(char[][] board, int row, int col) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
        || board[row][col] != 'O')
      return;

    board[row][col] = 'T';

    capture(board, row - 1, col);
    capture(board, row + 1, col);
    capture(board, row, col - 1);
    capture(board, row, col + 1);
  }
}
