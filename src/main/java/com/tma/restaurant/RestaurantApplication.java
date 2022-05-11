package main.java.com.tma.restaurant;
import main.java.com.tma.restaurant.dal.BillDAL;
import main.java.com.tma.restaurant.dal.MenuDAL;
import main.java.com.tma.restaurant.presentation.RestaurantGUI;
import main.java.com.tma.restaurant.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * RestaurantApplication class
 *
 * @author intern.npqhuy
 */
public class RestaurantApplication {

    /**
     * main function to run restaurant project
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
//        menu();
//        bill();

        RestaurantGUI restaurantGUI = new RestaurantGUI();
        restaurantGUI.show();
    }

//    public static void bill() throws IOException {
//        MenuItem softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
//        MenuItem alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
//        MenuItem breakfast = new BreakfastMenuItem("3", "Bread", "Breakfast", "bread.png", 15);
//        MenuItem lunch = new LunchMenuItem("4", "Rice", "Lunch", "rice.png", 30);
//        MenuItem dinner = new DinnerMenuItem("5", "Beef", "Dinner", "beef.png", 50);
//
//         Bill bill1 = new Bill("1", new Date());
//        bill1.getBillItemList().add(new BillItem(softDrink, 7));
//        bill1.getBillItemList().add(new BillItem(breakfast, 2));
//
//        Bill bill2 = new Bill("2", new Date());
//        bill2.getBillItemList().add(new BillItem(alcohol, 2));
//        bill2.getBillItemList().add(new BillItem(dinner, 2));
//
//        Bill bill3 = new Bill("3", new Date());
//        bill3.getBillItemList().add(new BillItem(breakfast, 4));
//        bill3.getBillItemList().add(new BillItem(lunch, 4));
//
//        List<Bill> billList = new ArrayList<>();
//        billList.add(bill1);
//        billList.add(bill2);
//        billList.add(bill3);
//
//        new BillDAL().write(billList);
//    }
//
//    public static void menu() {
//        MenuItem softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
//        MenuItem alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
//        MenuItem breakfast = new BreakfastMenuItem("3", "Bread", "Breakfast", "bread.png", 15);
//        MenuItem lunch = new LunchMenuItem("4", "Rice", "Lunch", "rice.png", 30);
//        MenuItem dinner = new DinnerMenuItem("5", "Beef", "Dinner", "beef.png", 50);
//
//        List<MenuItem> menuList = new ArrayList<>();
//        menuList.add(softDrink);
//        menuList.add(alcohol);
//        menuList.add(breakfast);
//        menuList.add(lunch);
//        menuList.add(dinner);
//
//        new MenuDAL().write(menuList);
//    }
}
