package main.java.com.tma.restaurant.model;

/**
 * DinnerMenu class
 * extends FoodMenu abstract class
 *
 * @author intern.npqhuy
 */
public class DinnerMenuItem extends FoodMenuItem {

    /**
     * Init DinnerMenu object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public DinnerMenuItem(String id, String name, String description, String image, float price) {
        super(id, name, description, image, price);
    }
}
