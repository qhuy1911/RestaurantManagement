package com.tma.restaurant.DAL;

import com.tma.restaurant.DTO.*;
import com.tma.restaurant.utils.Constants;

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

    /**
     * save list menu to menu.txt file
     *
     * @param menuList: list menu to save
     */
    public void write(List<Menu> menuList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(Constants.MENU_FILE_PATH);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(menuList);
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
     * Read list menu from file
     *
     * @return list menu
     */
    public List<Menu> read() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Menu> menuList = new ArrayList<>();
        try {
            fis = new FileInputStream(Constants.MENU_FILE_PATH);
            ois = new ObjectInputStream(fis);
            menuList = (List<Menu>) ois.readObject();
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
        return menuList;
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
