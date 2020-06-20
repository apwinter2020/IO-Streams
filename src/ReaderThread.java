import java.io.InputStream;
import java.util.Scanner;

public class ReaderThread extends Thread {

    InputStream inputStream;

    ReaderThread(InputStream inputStream) {
        this.inputStream=inputStream;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(inputStream);

        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }

        scanner.close();
    }
}
