import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WriterThread extends Thread {
    OutputStream outputStream;

    WriterThread(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(new File("output.txt"));
            PrintStream printStream = new PrintStream(outputStream);

            while(scanner.hasNext()) {
                printStream.println("Sent from WriterThread: "+scanner.next());
            }

            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
