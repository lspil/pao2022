public class Ex1 {

    public static void main(String[] args) {
        try {
            m();
        } catch (RuntimeException e) {
            System.out.println("B");
        }
    }

    public static void m() {
        try {
            System.out.println("A");
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            System.out.println("C");
        }
    }
}
