package com.tma.restaurant.DTO;

/**
 * Alcohol class
 * extends DrinkMenu abstract class
 *
 * @author intern.npqhuy
 */
public class Alcohol extends DrinkMenu{

    /**
     * Init Alcohol object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public Alcohol(String id, String name, String description, String image, float price) {
        super(id, name, description, image, price);
    }
}
