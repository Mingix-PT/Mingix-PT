package Lab01;
import java.util.Scanner;
public class StarTriangle {
    public static void main(String[] args) {
        int n;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = keyboard.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
