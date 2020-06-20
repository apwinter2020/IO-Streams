import java.io.*;

public class ObjectWriterThread extends Thread {
    OutputStream outputStream;
    ObjectOutputStream objectOutputStream;

    ObjectWriterThread(OutputStream outputStream) throws IOException {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(3534.3453);
            objectOutputStream.writeObject(33453);
            objectOutputStream.writeObject("sdfsdfsdf");
            objectOutputStream.writeObject(new ObjectsPackage.SampleObject("AP2020"));

//            objectOutputStream.close();
            Thread.sleep(1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
