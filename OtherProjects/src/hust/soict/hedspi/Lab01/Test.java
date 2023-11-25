package Lab01;
import javax.swing.JOptionPane;
public class Test {
    public static void main (String[] arg) {
        int option = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                "Choose an option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[] {"Yes", "No"},
                "Yes");
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.out.println(option);
        System.exit(0);
    }
}
