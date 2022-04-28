package com.tma.restaurant.DTO;

/**
 * DrinkMenu abstract class
 * extends Menu abstract class
 *
 * @author intern.npqhuy
 */
public abstract class DrinkMenu extends Menu {

    /**
     * Init DrinkMenu object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public DrinkMenu(String id, String name, String description, String image, float price) {
        super(id, name, description, image, price);
    }
}
