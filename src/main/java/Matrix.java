import java.util.Random;

public class Matrix {
    private final int[][] matrix;
    private int[][] matrixNew;

    public Matrix(int matrixSize) {
        matrix = new int[matrixSize][matrixSize];
        matrixNew = matrix;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                Random random = new Random();
                matrix[i][j] = random.nextInt(256);
            }
        }
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%5d", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    public int getFirstNum() {
        return matrixNew[0][0];
    }

    public int getLastNum() {
        return matrixNew[matrix.length-1][matrix.length-1];
    }

    public void printOriginal() {
        print(matrix);
    }

    public int[][] rotate90(int[][] matrix) {
        int size = matrix.length;
        matrixNew = new int[matrix.length][matrix.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixNew[i][j] = matrix[size - 1 - j][i];
            }
        }
        return matrixNew;
    }

    public int[][] rotate180(int[][] matrix) {
        int size = matrix.length;
        matrixNew = new int[matrix.length][matrix.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixNew[i][j] = matrix[size - 1 - i][size - 1 - j];
            }
        }
        return matrixNew;
    }

    public int[][] rotate270(int[][] matrix) {
        int size = matrix.length;
        matrixNew = new int[matrix.length][matrix.length];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrixNew[i][j] = matrix[j][size - 1 - i];
            }
        }
        return matrixNew;
    }

    public void rotate(int angle) {
        if (angle % 90 == 0) {
            switch (angle % 360) {
                case 90:
                    print(rotate90(matrixNew));
                    return;
                case 180:
                    print(rotate180(matrixNew));
                    return;
                case 270:
                    print(rotate270(matrixNew));
            }
        }
    }

    public int amountOfElements() {
        return (matrix.length * matrixNew.length);
    }

    public int getSIZE(int[][] matrixL) {
        return matrixL.length;
    }

    public int[][] getMatrix() {
        return matrixNew;
    }
}