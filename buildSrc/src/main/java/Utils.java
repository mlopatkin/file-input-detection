import java.io.*;

public class Utils {
    public static void printAndClose(String filename, InputStream is) throws IOException {
        try {
            print(filename, is);
        } finally {
            is.close();
        }
    }

    public static void printAndClose(String filename, Reader reader) throws IOException {
        try {
            print(filename, reader);
        } finally {
            reader.close();
        }
    }

    public static void print(String filename, Reader reader) throws IOException {
        CharArrayWriter out = new CharArrayWriter();
        char[] buf = new char[8192];
        int r = reader.read(buf);
        while (r >= 0) {
            out.write(buf, 0, r);
            r = reader.read(buf);
        }
        System.out.println(filename);
        System.out.println(out);
    }


    public static void print(String filename, InputStream is) throws IOException {
        print(filename, new InputStreamReader(is));
    }
}
