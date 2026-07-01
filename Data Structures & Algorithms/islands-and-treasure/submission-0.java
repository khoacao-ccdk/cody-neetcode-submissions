class Solution {
  public void islandsAndTreasure(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          bfs(grid, i, j, new HashSet<>());
        }
      }
    }
  }

  private void bfs(int[][] grid, int row, int col, Set<Integer> visited) {
    int height = grid.length, width = grid[0].length;

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {row, col});
    int level = 0;

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] curr = q.poll();
        int currRow = curr[0], currCol = curr[1];

        grid[currRow][currCol] = Math.min(level, grid[currRow][currCol]);
        visited.add(currRow * height + currCol);

        if (currRow > 0 && grid[currRow - 1][currCol] > 0
            && !visited.contains((currRow - 1) * height + currCol)) {
          q.add(new int[] {currRow - 1, currCol});
        }

        if (currRow < height-1 && grid[currRow + 1][currCol] > 0
            && !visited.contains((currRow + 1) * height + currCol)) {
          q.add(new int[] {currRow + 1, currCol});
        }

        if (currCol > 0 && grid[currRow][currCol-1] > 0
            && !visited.contains(currRow * height + (currCol - 1))) {
          q.add(new int[] {currRow, currCol-1});
        }

        if (currCol < width - 1 && grid[currRow][currCol+1] > 0
            && !visited.contains(currRow * height + (currCol + 1))) {
          q.add(new int[] {currRow, currCol+1});
        }
      }

      level++;
    }
  }
}
