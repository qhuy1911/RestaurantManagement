package com.tma.restaurant.DTO;

import java.io.Serializable;

/**
 * MenuItem class
 * implement Serializable
 *
 * @author intern.npqhuy
 */
public class MenuItem implements Serializable {
    private Menu menu;
    private int quantity;

    /**
     * Init MenuItem object
     *
     * @param menu : the menu
     * @param quantity : the quantity of the menu item
     */
    public MenuItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    /**
     * Get menu of the menu items
     *
     * @return menu  of th menu items
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Set menu of the menu item
     *
     * @param menu : the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
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
    public float getTotal() {
        return menu.getPrice() * quantity;
    }
}
