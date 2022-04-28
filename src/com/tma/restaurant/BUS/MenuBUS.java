package com.tma.restaurant.BUS;

import com.tma.restaurant.DAL.MenuDAL;
import com.tma.restaurant.DTO.*;

import java.util.List;

/**
 * MenuBUS class
 * (Business Logic Layer)
 *
 * @author intern.npqhuy
 */
public class MenuBUS {
    private List<Menu> menuList;
    private MenuDAL menuDAL;

    /**
     * Init MenuDAL object
     * Read list menu from file
     */
    public MenuBUS() {
        menuDAL = new MenuDAL();
        menuList = menuDAL.read();
    }

    /**
     * Add menu to menu list
     * Write menu list to file
     *
     * @param menu : menu to add to menu list
     */
    public void add(Menu menu) {
        menuList.add(menu);
        menuDAL.write(menuList);
    }

    /**
     * Update menu information in bill list
     * Write menu list to file
     *
     * @param id : id of the menu you want to update
     * @param name : name to update the menu
     * @param description : description to update the menu
     * @param image : image to update the menu
     * @param price : price to update the menu
     */
    public void update(String id, String name, String description, String image, float price) {
        for (Menu menu : menuList) {
            if (menu.getId().equals(id)) {
                menu.setName(name);
                menu.setDescription(description);
                menu.setImage(image);
                menu.setPrice(price);
            }
        }
        menuDAL.write(menuList);
    }

    /**
     * Delete menu from menu list
     *
     * @param id : id of the menu you want to delete
     */
    public void delete(String id) {
        Menu menu = null;
        for (Menu item : menuList) {
            if (item.getId().equals(id)) {
                menu = item;
            }
        }
        menuList.remove(menu);
        menuDAL.write(menuList);
    }

    /**
     * Get menu from menu list by id
     *
     * @param id : id of the menu want to get
     * @return the menu with id passed in
     */
    public Menu getMenuById(String id) {
        for (Menu menu : menuList) {
            if (menu.getId().equals(id)){
                return menu;
            }
        }
        return null;
    }

    /**
     * Get the menu list
     *
     * @return the menu list
     */
    public List<Menu> getMenuList() {
        return menuList;
    }
}
