package com.tma.restaurant.GUI;

import java.util.Scanner;

/**
 * MainGUI class
 * (Presentation Layer - GUI)
 *
 * @author intern.npqhuy
 */
public class MainGUI {

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
                case "1":
                    MenuGUI.show();
                    break;
                case "2":
                    BillGUI.show();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! please choose action in above menu:");
                    break;
            }
            if (exit) {
                System.out.println("Exited");
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
