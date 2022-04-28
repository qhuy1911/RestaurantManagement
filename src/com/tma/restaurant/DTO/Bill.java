package com.tma.restaurant.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * Bill class
 * implements Serializable
 *
 * @author intern.npqhuy
 */
public class Bill implements Serializable {
    private String id;
    private MenuItem menuItem;
    private Date orderDate;

    /**
     * Init Bill object
     *
     * @param id : the id of the menu
     * @param menuItem : the menuItem of the menu
     * @param orderDate : the order date of the menu
     */
    public Bill(String id, MenuItem menuItem, Date orderDate) {
        this.id = id;
        this.menuItem = menuItem;
        this.orderDate = orderDate;
    }

    /**
     * Get id of the menu
     *
     * @return id of the menu
     */
    public String getId() {
        return id;
    }

    /**
     * Set id of the menu
     *
     * @param id : the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get menu item of the menu
     *
     * @return menu item of the menu
     */
    public MenuItem getMenuItem() {
        return menuItem;
    }

    /**
     * Set menu item of the menu
     *
     * @param menuItem : the menu item to set
     */
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    /**
     * Get order date of the menu
     *
     * @return order date of the menu
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set order date of the menu
     *
     * @param orderDate : the order date to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
