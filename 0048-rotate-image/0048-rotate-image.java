class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=i+1;j<matrix.length;j++) {
                swap(matrix, i, j);
            }
        }
        for(int i=0;i<matrix.length;i++) {
            int low = 0, high = matrix.length-1;
            while(low<high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
    private void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
}