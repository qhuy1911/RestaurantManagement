package main.java.com.tma.restaurant.presentation;

import main.java.com.tma.restaurant.business.MenuBusiness;
import main.java.com.tma.restaurant.model.*;
import main.java.com.tma.restaurant.utils.Constants;

import java.util.List;
import java.util.Scanner;

/**
 * MenuManagementGUI class
 * (Presentation Layer - GUI)
 *
 * @author intern.npqhuy
 */
public class MenuManagementGUI {
    private Scanner scanner = new Scanner(System.in);
    private MenuBusiness menuBusiness = new MenuBusiness();

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
                case (Constants.SHOW_MENU_LIST):
                    showMenuList();
                    break;
                case (Constants.ADD_MENU):
                    add();
                    break;
                case (Constants.UPDATE_MENU):
                    update();
                    break;
                case (Constants.DELETE_MENU):
                    delete();
                    break;
                case (Constants.BACK):
                    back = true;
                    break;
                default:
                    System.out.println(Constants.INVALID_ACTION);
                    break;
            }
            if (back) break;
            showOptionMenu();
        }

    }

    /**
     * Show menu list to screen
     */
    public void showMenuList() {
        List<MenuItem> menuItemList = menuBusiness.getMenuList();
        System.out.println("------------------------------MENU LIST-----------------------------");
        System.out.format("%5s | ", "ID");
        System.out.format("%10s | ", "Name");
        System.out.format("%15s | ", "Description");
        System.out.format("%15s | ", "Image");
        System.out.format("%11s%n", "Price");
        System.out.println("--------------------------------------------------------------------");
        for (MenuItem menuItem : menuItemList) {
            System.out.format("%5s | ", menuItem.getId());
            System.out.format("%10s | ", menuItem.getName());
            System.out.format("%15s | ", menuItem.getDescription());
            System.out.format("%15s | ", menuItem.getImage());
            System.out.format("%10.1f$%n", menuItem.getPrice());
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
        MenuItem menuItem = createMenu(id, name, description, image, price);
        menuBusiness.add(menuItem);
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
        menuBusiness.update(id, name, description, image, price);
    }

    /**
     * Delete menu from menu list
     */
    public void delete() {
        String id = inputExistedId();
        menuBusiness.delete(id);
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
            System.out.print(Constants.INPUT_MENU_ID);
            boolean existed = false;
            String id = scanner.nextLine();
            for (MenuItem menuItem : menuBusiness.getMenuList()) {
                if (menuItem.getId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println(Constants.EXISTED_ID);
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
        System.out.print(Constants.INPUT_MENU_NAME);
        return scanner.nextLine();
    }

    /**
     * Get input description of menu from user
     *
     * @return input description from user
     */
    public String inputDescription() {
        System.out.print(Constants.INPUT_MENU_DESCRIPTION);
        return scanner.nextLine();
    }

    /**
     * Get input image of the menu from user
     *
     * @return input image from user
     */
    public String inputImage() {
        System.out.print(Constants.INPUT_MENU_IMAGE);
        return scanner.nextLine();
    }

    /**
     * Get input price of menu from user
     *
     * @return input price of user
     */
    public float inputPrice() {
        System.out.print(Constants.INPUT_MENU_PRICE);
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
        System.out.print(Constants.INPUT_MENU_TYPE);
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
    public MenuItem createMenu(String id, String name, String description, String image, float price) {
        MenuItem menuItem = null;
        boolean check = true;
        int menuType;
        while (true) {
            menuType = inputMenuType();
            switch (menuType) {
                case Constants.SOFT_DRINK_TYPE:
                    menuItem = new SoftDrink(id, name, description, image, price);
                    break;
                case Constants.ALCOHOL_TYPE:
                    menuItem = new Alcohol(id, name, description, image, price);
                    break;
                case Constants.BREAKFAST_TYPE:
                    menuItem = new BreakfastMenuItem(id, name, description, image, price);
                    break;
                case Constants.LUNCH_TYPE:
                    menuItem = new LunchMenuItem(id, name, description, image, price);
                    break;
                case Constants.DINNER_TYPE:
                    menuItem = new DinnerMenuItem(id, name, description, image, price);
                    break;
                default:
                    check = false;
                    System.out.println(Constants.INVALID_MENU_TYPE);
                    break;
            }
            if (check) {
                return menuItem;
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
            System.out.print(Constants.INPUT_MENU_ID);
            String id = scanner.nextLine();
            for (MenuItem menuItem : new MenuBusiness().getMenuList()) {
                if (menuItem.getId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                return id;
            }
            System.out.print(Constants.INVALID_ID);
        }
    }
}
