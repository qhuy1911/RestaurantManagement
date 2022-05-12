package main.java.com.tma.restaurant.presentation;

import main.java.com.tma.restaurant.utils.Constants;

import java.util.Scanner;

/**
 * MainGUI class
 * (Presentation Layer - GUI)
 *
 * @author intern.npqhuy
 */
public class RestaurantGUI {

    /**
     * Display main interface to screen
     */
    public void show() {
        boolean exit = false;
        String choose;
        Scanner scanner = new Scanner(System.in);
        MenuManagementGUI MenuGUI = new MenuManagementGUI();
        BillManagementGUI BillGUI = new BillManagementGUI();

        showOptionMenu();
        while(true) {
            choose = scanner.nextLine();
            switch (choose) {
                case (Constants.MENU_MANAGEMENT):
                    MenuGUI.show();
                    break;
                case (Constants.BILL_MANAGEMENT):
                    BillGUI.show();
                    break;
                case (Constants.EXIT):
                    exit = true;
                    break;
                default:
                    System.out.println(Constants.INVALID_ACTION);
                    break;
            }
            if (exit) {
                System.out.println(Constants.EXITED);
                break;
            }
            showOptionMenu();
        }
    }

    /**
     * Show menu option to screen
     */
    public void showOptionMenu() {
        System.out.println("----------MANAGEMENT----------");
        System.out.println("1. Menu");
        System.out.println("2. Bill");
        System.out.println("0. Exit");
        System.out.println("------------------------------");
        System.out.print("Please choose: ");
    }
}
