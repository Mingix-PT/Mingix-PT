import javax.swing.JOptionPane;
import java.util.Scanner;
public class CalDoubleNumbers {
    public static void main(String[] args) {
        double dbNum1, dbNum2;
        String strNotificationSum = "Sum of two input numbers are: ";
        String strNotificationDif = "Different of two input numbers are: ";
        String strNotificationProduct = "Product of two input numbers are: ";
        String strNotificationQuotient = "Quotient of two input numbers are: ";
        Scanner input = new Scanner(System.in);
        System.out.printf("Please input the first number: ");
        dbNum1 = input.nextDouble();
        System.out.printf("Please input the second number: ");
        dbNum2 = input.nextDouble();
        strNotificationSum += dbNum1 + dbNum2;
        strNotificationDif += dbNum1 - dbNum2;
        strNotificationProduct += dbNum1 * dbNum2;
        if (dbNum2 == 0)
            strNotificationQuotient = "Cannot divide by zero!";
        else
            strNotificationQuotient += dbNum1 / dbNum2;
        System.out.println(strNotificationSum);
        System.out.println(strNotificationDif);
        System.out.println(strNotificationProduct);
        System.out.println(strNotificationQuotient);
    }
}