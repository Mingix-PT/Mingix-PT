package Lab01;
import java.util.Scanner;

public class DayInMonth {
    public static void main (String[] args) {
        boolean validMonth;
        boolean validYear;
        int days = 0;
        do {
            String month;
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter month: ");
            month = keyboard.nextLine();
            System.out.print("Enter year: ");
            int year = keyboard.nextInt();
            switch (month) {
                case "1":
                case "3":
                case "5":
                case "7":
                case "8":
                case "10":
                case "12":
                case "January":
                case "March":
                case "May":
                case "July":
                case "August":
                case "October":
                case "December":
                case "Jan":
                case "Mar":
                case "Jul":
                case "Aug":
                case "Oct":
                case "Dec":
                case "Jan.":
                case "Mar.":
                case "Jul.":
                case "Aug.":
                case "Oct.":
                case "Dec.":
                    days = 31;
                    validMonth = true;
                    break;
                case "4":
                case "6":
                case "9":
                case "11":
                case "April":
                case "June":
                case "September":
                case "November":
                case "Apr":
                case "Jun":
                case "Sep":
                case "Nov":
                case "Apr.":
                case "Jun.":
                case "Sep.":
                case "Nov.":
                    days = 30;
                    validMonth = true;
                    break;
                case "2":
                case "February":
                case "Feb":
                case "Feb.":
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        days = 29;
                    } else {
                        days = 28;
                    }
                    validMonth = true;
                    break;
                default:
                    validMonth = false;
                    System.out.println("Invalid month. Please try again.");
            }
            if (year < 0) {
                validYear = false;
                System.out.println("Invalid year. Please try again.");
            }
            else {
                validYear = true;
            }
        } while (!validMonth || !validYear);
        System.out.println("Number of days: " + days);
    }
}
