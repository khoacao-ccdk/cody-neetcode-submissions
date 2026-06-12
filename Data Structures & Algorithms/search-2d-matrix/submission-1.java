class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int height = matrix.length, width = matrix[0].length;

    int l = 0, r = width * height;

    while(l < r) {
        int mid = l + (r-l)/2;
        int row = mid / width, col = mid % width;
        
        if(matrix[row][col] == target) 
            return true;
        
        if(matrix[row][col] > target) 
            r = mid;
        else
            l = mid+1;
    }

    return false;
  }
}
