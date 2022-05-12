package main.java.com.tma.restaurant.dal;

import main.java.com.tma.restaurant.utils.Constants;
import main.java.com.tma.restaurant.utils.FileHandler;
import main.java.com.tma.restaurant.model.Bill;

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

    private FileHandler fileHandler = new FileHandler();

    /**
     * save list bill to bills.txt file
     *
     * @param billList: the list bill to save
     */
    public void write(List<Bill> billList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(Constants.BILL_FILE_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(billList);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } finally {
            fileHandler.closeStream(oos);
            fileHandler.closeStream(fos);
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
        }  catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fileHandler.closeStream(ois);
            fileHandler.closeStream(fis);
        }
        return billList;
    }
}
