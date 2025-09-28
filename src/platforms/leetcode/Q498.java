public class Q498 {
    public static int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] res = new int[row * col];
        boolean dir = true;
        int x = 0, y = 0;

        for (int i = 0; i < row * col; i++) {
            res[i] = mat[x][y];

            if (dir) {
                if (x - 1 >= 0 && y + 1 < col) {
                    x--;
                    y++;
                } else {
                    dir = false;
                    if (y + 1 < col) {
                        y++;
                    } else {
                        x++;
                    }
                }
            } else {
                if (x + 1 < row && y - 1 >= 0) {
                    x++;
                    y--;
                } else {
                    dir = true;
                    if (x + 1 < row) {
                        x++;
                    } else {
                        y++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[] res = findDiagonalOrder(mat);
        for (int i : res)
            System.out.print(i + " ");
    }
}
