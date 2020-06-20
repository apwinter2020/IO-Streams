import ObjectsPackage.SampleObject;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static String loadData(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        return scanner.nextLine();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("input.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("output.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 64);
        PrintStream filePrintStream = new PrintStream(bufferedOutputStream);

        String myString = loadData(bufferedInputStream);

//        System.out.println(loadData(System.in));
        System.out.println(myString);
        filePrintStream.println(myString);
        filePrintStream.println(myString);
        filePrintStream.println(myString);
        filePrintStream.println(myString);
        filePrintStream.println(myString);
//        filePrintStream.flush();

        bufferedOutputStream.flush();

//        bufferedOutputStream.flush();

//        filePrintStream.close();
//        bufferedOutputStream.close();
        fileOutputStream.close();

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);

//        PrintWriter printWriter = new PrintWriter(pipedOutputStream);
//        printWriter.println("Sample String");
//        printWriter.flush();

        PrintStream printStream = new PrintStream(pipedOutputStream);
        printStream.println("Sample String");
        printStream.flush();
        System.out.println(loadData(pipedInputStream));

        PipedInputStream pipedInputStreamForThread = new PipedInputStream();
        PipedOutputStream pipedOutputStreamForThread = new PipedOutputStream(pipedInputStreamForThread);

        WriterThread writerThread = new WriterThread(pipedOutputStreamForThread);
        ReaderThread readerThread = new ReaderThread(pipedInputStreamForThread);

        writerThread.start();
        readerThread.start();

//        Thread.sleep(2000);

        PipedInputStream pipedInputStreamForObject = new PipedInputStream();
        PipedOutputStream pipedOutputStreamForObject = new PipedOutputStream(pipedInputStreamForObject);

//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStreamForObject);
//        ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStreamForObject);
//
//        objectOutputStream.writeObject(32432);
//        objectOutputStream.writeObject(32432.234234);
//        objectOutputStream.writeObject(new Objects.SampleObject("AP2020"));
//        objectOutputStream.flush();
//
//        for(int i=0;i<3;i++) {
//            Object object = objectInputStream.readObject();
//            System.out.println(object.getClass() + ": " + object);
//        }

        ObjectWriterThread objectWriterThread = new ObjectWriterThread(pipedOutputStreamForObject);
        ObjectReaderThread objectReaderThread = new ObjectReaderThread(pipedInputStreamForObject);

        objectWriterThread.start();
        Thread.sleep(100);
        objectReaderThread.start();

        System.out.println(SampleObject.class.getCanonicalName());
    }
}
