package Lab01;
import java.util.Scanner;

public class SortAndAverageArray {
    public static void main (String[] args) {
        int n;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        n = keyboard.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            a[i] = keyboard.nextInt();
            sum += a[i];
        }
        System.out.print("\n");
        System.out.print("Sorted array: ");
        for (int i = 0; i < n - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
        System.out.print("Average: " + (double)sum / n);
    }
}
