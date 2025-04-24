package Matrices;

import java.util.Arrays;

public class SetMatrixZero {
    public static int[][] setMatrixZeros(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean frow = false;
        boolean fcol = false;
        // Replace this placeholder return statement with your code
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && mat[i][j] == 0) {
                    frow = true;
                }
                if (j == 0 && mat[i][j] == 0) {
                    fcol = true;
                }
                if (j > 0 && i > 0) {
                    if (mat[i][j] == 0) {
                        mat[0][j] = 0;
                        mat[i][0] = 0;
                    }
                }

            }
        }

        for (int j = 1; j < cols; j++) {
            if (mat[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    mat[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            if (mat[i][0] == 0) {
                Arrays.fill(mat[i], 0);
            }

        }

        if (frow) {
            Arrays.fill(mat[0], 0);
        }
        if (fcol) {
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 0;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        setMatrixZeros(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 9 } });
    }
}
