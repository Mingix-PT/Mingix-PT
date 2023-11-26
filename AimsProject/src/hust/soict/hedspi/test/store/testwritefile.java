package hust.soict.hedspi.test.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class testwritefile {
    public static void main(String[] args) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File("hust/soict/hedspi/test/store/test.txt");
            FileWriter fw = new FileWriter(f);
            //Bước 2: Ghi dữ liệu
            fw.write("HIHI");
            //Bước 3: Đóng luồng
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
}
