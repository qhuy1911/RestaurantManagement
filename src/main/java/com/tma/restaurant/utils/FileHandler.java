package main.java.com.tma.restaurant.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * FileHandler class
 *
 * @author intern.npqhuy
 */
public class FileHandler {

    /**
     * close input stream
     *
     * @param is: input stream
     */
    public void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * close output stream
     *
     * @param os: output stream
     */
    public void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
