package com.tma.restaurant.DAL;

import com.tma.restaurant.DTO.Bill;
import com.tma.restaurant.utils.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BillDAL class
 * (Data Access Layer)
 *
 * @author intern.npqhuy
 */
public class BillDAL {

    /**
     * save list bill to bills.txt file
     *
     * @param billList: the list bill to save
     */
    public void write(List<Bill> billList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(Constants.BILL_FILE_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(billList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(oos);
            closeStream(fos);
        }
    }

    /**
     * Read list bill from bills.txt file
     *
     * @return list bill
     */
    public List<Bill> read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Bill> billList = new ArrayList<>();
        try {
            fis = new FileInputStream(Constants.BILL_FILE_PATH);
            ois = new ObjectInputStream(fis);
            billList = (List<Bill>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(ois);
            closeStream(fis);
        }
        return billList;
    }

    /**
     * close input stream
     *
     * @param is: input stream
     */
    private void closeStream(InputStream is) {
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
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
