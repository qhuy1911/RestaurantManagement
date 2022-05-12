package main.java.com.tma.restaurant.business;

import main.java.com.tma.restaurant.dal.MenuDAL;
import main.java.com.tma.restaurant.model.MenuItem;

import java.util.List;

/**
 * MenuBUS class
 * (Business Logic Layer)
 *
 * @author intern.npqhuy
 */
public class MenuBusiness {
    private List<MenuItem> menuItemList;
    private MenuDAL menuDAL;

    /**
     * Init MenuDAL object
     * Read list menu from file
     */
    public MenuBusiness() {
        menuDAL = new MenuDAL();
        menuItemList = menuDAL.read();
    }

    /**
     * Add menu to menu list
     * Write menu list to file
     *
     * @param menuItem : menu to add to menu list
     */
    public void add(MenuItem menuItem) {
        menuItemList.add(menuItem);
        menuDAL.write(menuItemList);
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
        for (MenuItem menuItem : getMenuList()) {
            if (menuItem.getId().equals(id)) {
                menuItem.setName(name);
                menuItem.setDescription(description);
                menuItem.setImage(image);
                menuItem.setPrice(price);
            }
        }
        menuDAL.write(menuItemList);
    }

    /**
     * Delete menu from menu list
     *
     * @param id : id of the menu you want to delete
     */
    public void delete(String id) {
        MenuItem menuItem = null;
        for (MenuItem item : getMenuList()) {
            if (item.getId().equals(id)) {
                menuItem = item;
            }
        }
        menuItemList.remove(menuItem);
        menuDAL.write(menuItemList);
    }

    /**
     * Get menu from menu list by id
     *
     * @param id : id of the menu want to get
     * @return the menu with id passed in
     */
    public MenuItem getMenuById(String id) {
        for (MenuItem menuItem : getMenuList()) {
            if (menuItem.getId().equals(id)){
                return menuItem;
            }
        }
        return null;
    }

    /**
     * Get the menu list
     *
     * @return the menu list
     */
    public List<MenuItem> getMenuList() {
        menuItemList = menuDAL.read();
        return menuItemList;
    }
}
