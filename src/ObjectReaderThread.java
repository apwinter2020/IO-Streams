import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class ObjectReaderThread extends Thread {

    InputStream inputStream;
    ObjectInputStream objectInputStream;

    ObjectReaderThread(InputStream inputStream) throws IOException {
        this.inputStream=inputStream;
    }

    @Override
    public void run() {
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            while(true) {
                Object object = objectInputStream.readObject();
                System.out.println(object.getClass() + ": " + object.toString());
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Stream is closed");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
