package platforms.leetcode;

void main() {
    int[][] res = generateMatrix(2);
    for (var row : res) {
        for (int j = 0; j < res.length; j++) {
            System.out.print(row[j] + "\t");
        }
        System.out.println();
    }
}

public static int[][] generateMatrix(int n) {
    if (n == 1) return new int[][]{{1}};
    int[][] arr = new int[n][n];
    int layer = 0, val = 1;
    while (layer <= n / 2) {
        val = fill(arr, val, layer++, n);
    }
    return arr;
}

private static int fill(int[][] arr, int start, int layer, int n) {
    int i = layer, j = layer;
    while (j < n - layer) arr[i][j++] = start++;
    j--;
    start--;
    while (i < n - layer) arr[i++][j] = start++;
    start--;
    i--;
    while (j >= layer) arr[i][j--] = start++;
    start--;
    j++;
    while (i > layer) arr[i--][j] = start++;
    return start;
}
