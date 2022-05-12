package main.java.com.tma.restaurant;
import main.java.com.tma.restaurant.presentation.RestaurantGUI;

import java.io.IOException;

/**
 * RestaurantApplication class
 *
 * @author intern.npqhuy
 */
public class RestaurantApplication {

    /**
     * main function to run restaurant project
     *
     * @param args : arguments
     */
    public static void main(String[] args) throws IOException {
        RestaurantGUI restaurantGUI = new RestaurantGUI();
        restaurantGUI.show();
    }
}
