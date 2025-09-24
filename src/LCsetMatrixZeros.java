void main() {
    int[][] arr = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 5, 1}};
    setZeroes(arr);
    for (var row : arr) {
        for (var col : row) {
            System.out.print(col + "\t");
        }
        System.out.println();
    }
}

private void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean firstRow = false, firstCol = false;
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            firstRow = true;
            break;
        }
    }
    for (int i = 0; i < m; i++) {
        if (matrix[0][i] == 0) {
            firstCol = true;
            break;
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        if (matrix[i][0] == 0) {
            for (int j = 1; j < n; j++) matrix[i][j] = 0;
        }
    }
    for (int i = 1; i < n; i++) {
        if (matrix[0][i] == 0) {
            for (int j = 1; j < m; j++) matrix[j][i] = 0;
        }
    }
    if (firstRow) {
        for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
    if (firstCol) {
        for (int i = 0; i < n; i++) matrix[0][i] = 0;
    }
}