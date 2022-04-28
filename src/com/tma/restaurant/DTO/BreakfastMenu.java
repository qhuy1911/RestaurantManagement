package com.tma.restaurant.DTO;

/**
 * BreakfastMenu class
 * extends FoodMenu abstract class
 *
 * @author intern.npqhuy
 */
public class BreakfastMenu extends FoodMenu{

    /**
     * Init Breakfast object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public BreakfastMenu(String id, String name, String description, String image, float price) {
        super(id, name, description, image, price);
    }
}
