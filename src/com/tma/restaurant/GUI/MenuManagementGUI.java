package com.tma.restaurant.GUI;

import com.tma.restaurant.BUS.MenuBUS;
import com.tma.restaurant.DTO.*;
import com.tma.restaurant.utils.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * MenuManagementGUI class
 * (Presentation Layer - GUI)
 *
 * @author intern.npqhuy
 */
public class MenuManagementGUI {
    public Scanner scanner = new Scanner(System.in);
    public MenuBUS menuBUS = new MenuBUS();

    /**
     * Display menu management interface to screen
     */
    public void show() {
        String choose;
        boolean back = false;

        showOptionMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    showMenuList(menuBUS.getMenuList());
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    delete();
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid! please choose action in above menu:");
                    break;
            }
            if (back) break;
            showOptionMenu();
        }

    }

    /**
     * Show menu list to screen
     *
     * @param menuList : the menu list to show
     */
    public void showMenuList(List<Menu> menuList) {
        System.out.println("------------------------------MENU LIST-----------------------------");
        System.out.format("%5s | ", "ID");
        System.out.format("%10s | ", "Name");
        System.out.format("%15s | ", "Description");
        System.out.format("%15s | ", "Image");
        System.out.format("%11s%n", "Price");
        System.out.println("--------------------------------------------------------------------");
        for (Menu menu : menuList) {
            System.out.format("%5s | ", menu.getId());
            System.out.format("%10s | ", menu.getName());
            System.out.format("%15s | ", menu.getDescription());
            System.out.format("%15s | ", menu.getImage());
            System.out.format("%10.1f$%n", menu.getPrice());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    /**
     * Add menu to menu list
     */
    public void add() {
        String id = inputID();
        String name = inputName();
        String description = inputDescription();
        String image = inputImage();
        float price = inputPrice();
        Menu menu = createMenu(id, name, description, image, price);
        menuBUS.add(menu);
        scanner.nextLine();
    }

    /**
     * Update menu information in menu list
     */
    private void update() {
        String id = inputExistedId();
        String name = inputName();
        String description = inputDescription();
        String image = inputImage();
        float price = inputPrice(); // input price will skip next line
        scanner.nextLine(); // new line
        menuBUS.update(id, name, description, image, price);
    }

    /**
     * Delete menu from menu list
     */
    public void delete() {
        String id = inputExistedId();
        menuBUS.delete(id);
    }

    /**
     * Show option menu to screen
     */
    public void showOptionMenu() {
        System.out.println("--------MENU MANAGEMENT-------");
        System.out.println("1. Show Menu List");
        System.out.println("2. Create New Menu");
        System.out.println("3. Update Menu");
        System.out.println("4. Delete Menu");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.print("Please choose: ");
    }

    /**
     * Get input id of menu from user
     *
     * @return input id from user
     */
    public String inputID() {
        while (true) {
            System.out.print("Input menu id: ");
            boolean existed = false;
            String id = scanner.nextLine();
            for (Menu menu : menuBUS.getMenuList()) {
                if (menu.getId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println("Id is existed! Please again...");
                continue;
            }
            return id;
        }
    }

    /**
     * Get input name of menu from user
     *
     * @return input name from user
     */
    public String inputName() {
        System.out.print("Input menu name: ");
        return scanner.nextLine();
    }

    /**
     * Get input description of menu from user
     *
     * @return input description from user
     */
    public String inputDescription() {
        System.out.print("Input menu description: ");
        return scanner.nextLine();
    }

    /**
     * Get input image of the menu from user
     *
     * @return input image from user
     */
    public String inputImage() {
        System.out.print("Input menu image: ");
        return scanner.nextLine();
    }

    /**
     * Get input price of menu from user
     *
     * @return input price of user
     */
    public float inputPrice() {
        System.out.print("Input menu price: ");
        return scanner.nextFloat();
    }

    /**
     * Show menu type list to screen
     */
    public void showMenuTypeList() {
        System.out.println(Constants.SOFT_DRINK_TYPE +  " - Soft drink");
        System.out.println(Constants.ALCOHOL_TYPE +  " - Alcohol");
        System.out.println(Constants.BREAKFAST_TYPE +  " - Breakfast");
        System.out.println(Constants.LUNCH_TYPE +  " - Lunch");
        System.out.println(Constants.DINNER_TYPE +  " - Dinner");
    }

    /**
     * Get input menu type from user
     *
     * @return input menu type from user
     */
    public int inputMenuType() {
        showMenuTypeList();
        System.out.print("Input Menu Type: ");
        return scanner.nextInt();
    }

    /**
     * Validate input menu type from user
     * Create menu with information and menu type
     *
     * @param id : id of the menu
     * @param name : name of the menu
     * @param description : description of the menu
     * @param image : image of the menu
     * @param price :price of the menu
     * @return the menu with input information and menu type
     */
    public Menu createMenu(String id, String name, String description, String image, float price) {
        Menu menu = null;
        boolean check = true;
        int menuType;
        while (true) {
            menuType = inputMenuType();
            switch (menuType) {
                case Constants.SOFT_DRINK_TYPE:
                    menu = new SoftDrink(id, name, description, image, price);
                    break;
                case Constants.ALCOHOL_TYPE:
                    menu = new Alcohol(id, name, description, image, price);
                    break;
                case Constants.BREAKFAST_TYPE:
                    menu = new BreakfastMenu(id, name, description, image, price);
                    break;
                case Constants.LUNCH_TYPE:
                    menu = new LunchMenu(id, name, description, image, price);
                    break;
                case Constants.DINNER_TYPE:
                    menu = new DinnerMenu(id, name, description, image, price);
                    break;
                default:
                    check = false;
                    System.out.println("Invalid menu type!");
                    break;
            }
            if (check) {
                return menu;
            }
        }
    }

    /**
     * Get input id menu of the user
     * Check if that id exists
     * If existed return
     * Else input again
     *
     * @return the existed id menu from user
     */
    public String inputExistedId() {
        boolean existed = false;
        while (true) {
            System.out.print("Input menu id: ");
            String id = scanner.nextLine();
            for (Menu menu : new MenuBUS().getMenuList()) {
                if (menu.getId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                return id;
            }
            System.out.print("Invalid id!");
        }
    }
}
