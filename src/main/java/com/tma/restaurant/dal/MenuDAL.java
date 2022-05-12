package main.java.com.tma.restaurant.dal;

import main.java.com.tma.restaurant.model.MenuItem;
import main.java.com.tma.restaurant.utils.Constants;
import main.java.com.tma.restaurant.utils.FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MenuDAL class
 * (Data Access Layer)
 *
 * @author intern.npqhuy
 */
public class MenuDAL {

    private FileHandler fileHandler = new FileHandler();

    /**
     * Save list menu to menu.txt file
     *
     * @param menuItemList: list menu to save
     */
    public void write(List<MenuItem> menuItemList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(Constants.MENU_FILE_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(menuItemList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileHandler.closeStream(oos);
            fileHandler.closeStream(fos);
        }
    }

    /**
     * Read list menu from file
     *
     * @return list menu
     */
    public List<MenuItem> read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<MenuItem> menuItemList = new ArrayList<>();
        try {
            fis = new FileInputStream(Constants.MENU_FILE_PATH);
            ois = new ObjectInputStream(fis);
            menuItemList = (List<MenuItem>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            fileHandler.closeStream(ois);
            fileHandler.closeStream(fis);
        }
        return menuItemList;
    }
}