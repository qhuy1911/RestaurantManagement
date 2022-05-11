package main.java.com.tma.restaurant.utils;

public class Constants {
    // file path
    public static final String MENU_FILE_PATH = "C:\\Users\\intern.npqhuy\\IdeaProjects\\TMARestaurant\\src\\main\\resources\\menu.txt";
    public static final String BILL_FILE_PATH = "C:\\Users\\intern.npqhuy\\IdeaProjects\\TMARestaurant\\src\\main\\resources\\bills.txt";

    // Menu type
    public static final int SOFT_DRINK_TYPE = 1;
    public static final int ALCOHOL_TYPE = 2;
    public static final int BREAKFAST_TYPE = 3;
    public static final int LUNCH_TYPE = 4;
    public static final int DINNER_TYPE = 5;

    // Restaurant action
    public static final String MENU_MANAGEMENT = "1";
    public static final String BILL_MANAGEMENT = "2";
    public static final String EXIT = "0";

    // Menu action
    public static final String SHOW_MENU_LIST = "1";
    public static final String ADD_MENU = "2";
    public static final String UPDATE_MENU = "3";
    public static final String DELETE_MENU = "4";
    public static final String BACK = "0";

    // Bill action
    // Menu action
    public static final String SHOW_BILL_LIST = "1";
    public static final String ADD_BILL = "2";
    public static final String UPDATE_BILL = "3";
    public static final String DELETE_BILL = "4";
    public static final String ADD_BILL_ITEM = "5";
    public static final String DELETE_BILL_ITEM = "6";
    public static final String CLEAR_BILL = "7";
    public static final String PRICE_OF_BILL_LIST = "8";

    // Exception

    // Message
    public static final String INVALID_ACTION = "Invalid! Please choose action in above menu:";
    public static final String EXITED = "Exited";
    public static final String INVALID_MENU_TYPE = "Invalid menu type!";
    public static final String INVALID_ID = "Invalid ID! Please again...";
    public static final String EXISTED_ID = "Id is existed! Please again...";
    public static final String INVALID_QUANTITY = "Invalid quantity! Quantity must be a number";

    //Menu Message
    public static final String INPUT_MENU_ID = "Input menu id: ";
    public static final String INPUT_MENU_NAME = "Input menu name: ";
    public static final String INPUT_MENU_DESCRIPTION = "Input menu description: ";
    public static final String INPUT_MENU_IMAGE = "Input menu image: ";
    public static final String INPUT_MENU_PRICE = "Input menu price: ";
    public static final String INPUT_MENU_TYPE = "Input Menu Type: ";

    //Bill Message
    public static final String INPUT_BILL_ID = "Input bill id: ";
    public static final String INPUT_QUANTITY = "Input quantity: ";
}