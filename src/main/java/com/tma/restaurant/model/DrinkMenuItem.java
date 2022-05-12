package main.java.com.tma.restaurant.model;

/**
 * DrinkMenu abstract class
 * extends Menu abstract class
 *
 * @author intern.npqhuy
 */
public abstract class DrinkMenuItem extends MenuItem {

    /**
     * Init DrinkMenu object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public DrinkMenuItem(String id, String name, String description, String image, float price) {
        super(id, name, description, image, price);
    }
}
