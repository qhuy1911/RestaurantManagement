package main.java.com.tma.restaurant.model;

import java.io.Serializable;

/**
 * MenuItem class
 * implement Serializable
 *
 * @author intern.npqhuy
 */
public class BillItem implements Serializable {
    private MenuItem menuItem;
    private int quantity;

    /**
     * Init MenuItem object
     *
     * @param menuItem : the menu
     * @param quantity : the quantity of the menu item
     */
    public BillItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    /**
     * Get menu of the menu items
     *
     * @return menu  of th menu items
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * Set menu of the menu item
     *
     * @param menuItem : the menu to set
     */
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    /**
     * Get quantity of the menu item
     *
     * @return quantity of the menu item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity of the menu item
     *
     * @param quantity : the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get total price of the menu item
     *
     * @return total price of the menu item
     */
    public float getPriceBillItem() {
        return menuItem.getPrice() * quantity;
    }
}
