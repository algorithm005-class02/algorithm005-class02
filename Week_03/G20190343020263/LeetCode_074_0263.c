bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
    
    int i, j, mid , temp;
    
    if (matrix == NULL || matrixSize == 0 || *matrixColSize == 0)
      return false;

    i = 0;
    j = matrixSize * (*matrixColSize) - 1;

    while (i <= j)
    {
      mid = (i + j) / 2;
      temp = matrix[mid/(*matrixColSize)][mid%(*matrixColSize)];

      if (temp == target) 
        return true;
      else {
        if (temp > target)
          j = mid - 1;
        else 
          i = mid + 1;
      }
    }
    return false;
}
