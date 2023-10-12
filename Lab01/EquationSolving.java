import javax.swing.JOptionPane;
import java.util.Scanner;
public class EquationSolving {
    public static void main (String[] args) {
        System.out.println("Here is the options list:");
        System.out.println("1. First-degree equation with one variable:\n\tax + b = 0");
        System.out.println("2. First-degree equation with two variables:\n\ta11x1 + a12x2 = b1\n\ta21x1 + a22x2 = b2");
        System.out.println("3. Second-degree equation with one variable:\n\tax^2 + bx + c = 0");
        System.out.printf("Please choose an option between 1 and 3: ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        while (option < 1 || option > 3) {
            System.out.println("Error. Please choose from option 1 to 3: ");
            option = input.nextInt();
        }
        System.out.println("\nYou have chosen option " + option);
        if (option == 1) {
            double a, b, x;
            System.out.printf("Please input a: ");
            a = input.nextDouble();
            System.out.printf("Please input b: ");
            b = input.nextDouble();
            if (a == 0) {
                if (b == 0) {
                    System.out.println("The equation has infinite solutions");
                } else {
                    System.out.println("The equation has no solution");
                }
            } else {
                x = -b / a;
                System.out.println("The equation has one solution: x = " + x);
            }
        } else if (option == 2) {
            double a11, a12, a21, a22, b1, b2, x1, x2;
            System.out.printf("Please input a11: ");
            a11 = input.nextDouble();
            System.out.printf("Please input a12: ");
            a12 = input.nextDouble();
            System.out.printf("Please input b1: ");
            b1 = input.nextDouble();
            System.out.printf("Please input a21: ");
            a21 = input.nextDouble();
            System.out.printf("Please input a22: ");
            a22 = input.nextDouble();
            System.out.printf("Please input b2: ");
            b2 = input.nextDouble();
            if (a11 * a22 - a12 * a21 == 0) {
                if (b1 * a22 - b2 * a12 == 0 && b2 * a11 - b1 * a21 == 0) {
                    System.out.println("The equation has infinite solutions");
                } else {
                    System.out.println("The equation has no solution");
                }
            } else {
                x1 = (b1 * a22 - b2 * a12) / (a11 * a22 - a12 * a21);
                x2 = (b2 * a11 - b1 * a21) / (a11 * a22 - a12 * a21);
                System.out.println("The equation has one solution: x1 = " + x1 + ", x2 = " + x2);
            }
        } else {
            double a, b, c, delta, x1, x2;
            System.out.printf("Please input a: ");
            a = input.nextDouble();
            System.out.printf("Please input b: ");
            b = input.nextDouble();
            System.out.printf("Please input c: ");
            c = input.nextDouble();
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        System.out.println("The equation has infinite solutions");
                    } else {
                        System.out.println("The equation has no solution");
                    }
                } else {
                    x1 = -c / b;
                    System.out.println("The equation has one solution: x = " + x1);
                }
            } else {
                delta = b * b - 4 * a * c;
                if (delta < 0) {
                    System.out.println("The equation has no solution");
                } else if (delta == 0) {
                    x1 = -b / (2 * a);
                    System.out.println("The equation has one solution: x = " + x1);
                } else {
                    x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    System.out.println("The equation has two solutions: x1 = " + x1 + ", x2 = " + x2);
                }
            }
        }
    }
}