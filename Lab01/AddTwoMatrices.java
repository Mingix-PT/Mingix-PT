package Lab01;
import java.util.Scanner;

public class AddTwoMatrices {
    public static void main (String[] arg) {
        int m, n;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        m = keyboard.nextInt();
        System.out.print("Enter the number of columns: ");
        n = keyboard.nextInt();
        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        int[][] c = new int[m][n];
        System.out.println("Enter the first matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                a[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter the second matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                b[i][j] = keyboard.nextInt();
            }
        }
        System.out.print("The sum of two matrices is: ");
        for (int i = 0; i < m; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j ++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + " ");
            }
        }
    }
}
