import java.io.BufferedReader;

public class Eingabe {
    public static int readInt(BufferedReader in) {
        try {
            return Integer.parseInt(in.readLine());
        } catch (Throwable e) {
            return -1;
        }
    }
    public static char readChar(BufferedReader in) {
        try {
            return in.readLine().charAt(0);
        } catch (Throwable e) {
            return 'r';
        }
    }
}
