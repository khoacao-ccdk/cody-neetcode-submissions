class Solution {
  public int numIslands(char[][] grid) {
    int height = grid.length, width = grid[0].length;
    boolean[][] visited = new boolean[height][width];
    int numIsland = 0;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (visited[row][col] || grid[row][col] == '0')
          continue;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});

        while (!q.isEmpty()) {
          int[] curr = q.poll();
          int cRow = curr[0], cCol = curr[1];

          if(visited[cRow][cCol] || grid[cRow][cCol] == '0')
            continue;

          visited[cRow][cCol] = true;

          if (cRow > 0) {
            q.offer(new int[]{cRow-1, cCol});
          }
          if (cRow < height-1) {
            q.offer(new int[]{cRow+1, cCol});
          }
          if (cCol > 0) {
            q.offer(new int[]{cRow, cCol-1});
          }
          if (cCol < width - 1) {
            q.offer(new int[]{cRow, cCol+1});
          }
        }

        numIsland++;
      }
    }

    return numIsland;
  }
}
