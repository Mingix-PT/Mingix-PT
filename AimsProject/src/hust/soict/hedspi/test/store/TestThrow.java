package hust.soict.hedspi.test.store;

public class TestThrow{
    public  static void m1() throws Exception{
        System.out.println("Inside m1");
        throw new Exception("m1 exception");
    }
    public static void m2() throws Exception{
        System.out.println("Inside m2");
        m1();
    }
    public static void m3() throws Exception {
        try {
            System.out.println("Inside m3");
            m2();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void m4() {
        try {
            System.out.println("Inside m4");
            m3();
        } catch (Exception e) {
            System.out.println("Exception caught");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        m4();
    }
}
