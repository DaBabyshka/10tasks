import java.util.Scanner;

public class LocalMinimums {
    private static  boolean isLocalMinimum(int[][] matrix, int i, int j) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = Math.max(0, i – 1); row <= Math.min(rows – 1, i + 1); row++)
            for (int col = Math.max(0, j – 1); col <= Math.min(cols – 1, j + 1); col++) {
                if (row == i && col == j) continue;
                if (matrix[i][j] >= matrix[row][col]) {
                    return false;
                }
            }
        return true;
    }

    public static int countLocalMinimum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int localMinimumCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    localMinimumCount++;
                }
            }
        }
        return localMinimumCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк:");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов:");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Введите элементы матрицы:");
        for (int I = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        int result = countLocalMinimum(matrix);
        System.out.println("Число локальных минимумов: " + result);

        scanner.close();
    }
}
