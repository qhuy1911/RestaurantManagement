package main.java.com.tma.restaurant.presentation;

import main.java.com.tma.restaurant.business.BillItemBusiness;
import main.java.com.tma.restaurant.business.MenuBusiness;
import main.java.com.tma.restaurant.model.MenuItem;
import main.java.com.tma.restaurant.business.BillBusiness;
import main.java.com.tma.restaurant.model.Bill;
import main.java.com.tma.restaurant.model.BillItem;
import main.java.com.tma.restaurant.utils.Constants;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * BillManagementGUI class
 * (Presentation Layer)
 *
 * @author intern.npqhuy
 */
public class BillManagementGUI {
    private Scanner scanner = new Scanner(System.in);
    private MenuBusiness menuBusiness = new MenuBusiness();
    private BillBusiness billBusiness = new BillBusiness();
    private BillItemBusiness billItemBusiness = new BillItemBusiness();
    private MenuManagementGUI menuManagementGUI = new MenuManagementGUI();

    /**
     * Show bill management interface to screen
     */
    public void show() {
        String choose;
        boolean back = false;

        showOptionMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case Constants.SHOW_BILL_LIST:
                    showBillList();
                    break;
                case Constants.ADD_BILL:
                    addBill();
                    break;
                case Constants.UPDATE_BILL:
                    updateBill();
                    break;
                case Constants.DELETE_BILL:
                    deleteBill();
                    break;
                case Constants.ADD_BILL_ITEM:
                    addBillItem();
                    break;
                case Constants.DELETE_BILL_ITEM:
                    deleteBillItem();
                    break;
                case Constants.CLEAR_BILL:
                    clearBill();
                    break;
                case Constants.PRICE_OF_BILL_LIST:
                    calculateTotalPrice();
                    break;
                case Constants.BACK:
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
     * Calculate total price of bill list
     */
    private void calculateTotalPrice() {
        float totalPrice = billBusiness.getTotalPriceOfBillList();
        System.out.println("-------Total bill list--------");
        System.out.format("Total price: %15.1f $%n", totalPrice);
    }

    /**
     * Add bill to bill list
     */
    public void addBill() {
        String id = inputID();
        Date orderDate = new Date();

        try {
            billBusiness.addBill(id, orderDate);
        } catch (IOException e) {
            System.out.println("Failed to add bill" + e.getMessage());
        }
    }

    /**
     * Update bill information in bill list
     */
    public void updateBill() {
        String id = inputExistedID();
        String menuID = inputMenuID();
        MenuItem menuItem = menuBusiness.getMenuById(menuID);
        int quantity = inputQuantity();

        try {
            billBusiness.updateBill(id, menuItem, quantity);
        } catch (IOException e) {
            System.out.println("Failed to update bill" + e.getMessage());
        }
    }

    /**
     * Delete bill from bill list
     */
    public void deleteBill() {
        String id = inputExistedID();
        try {
            billBusiness.deleteBill(id);
        } catch (IOException e) {
            System.out.println("Failed to delete bill" + e.getMessage());
        }
    }

    /**
     * Get input id bill of the user
     * Check if that id exists
     * If existed return
     * Else input again
     *
     * @return the existed id menu from user
     */
    private String inputExistedID() {
        while (true) {
            System.out.print(Constants.INPUT_BILL_ID);
            boolean check = false;
            String id = scanner.nextLine();
            for (Bill bill : billBusiness.getBillList()) {
                if (bill.getId().equals(id)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                return id;
            }
            System.out.println(Constants.INVALID_ID);
        }
    }

    /**
     * Get input quantity of menu item from user
     *
     * @return input quantity from user
     */
    public int inputQuantity() {
        int qty;
        while (true) {
            try {
                System.out.print(Constants.INPUT_QUANTITY);
                qty = Integer.parseInt(scanner.nextLine());
                return qty;
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_QUANTITY);
            }
        }
    }

    /**
     * Get input menu id from user
     *
     * @return input menu id from user
     */
    public String inputMenuID() {
        while (true) {
            System.out.print(Constants.INPUT_MENU_ID);
            boolean check = false;
            String id = scanner.nextLine();
            for (MenuItem menuItem : menuBusiness.getMenuList()) {
                if (menuItem.getId().equals(id)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                return id;
            }
            System.out.println(Constants.INVALID_ID);
        }
    }

    /**
     * Get input bill id from user
     * If existed input again
     * Else return
     *
     * @return input bill id from user
     */
    public String inputID() {
        while (true) {
            System.out.print(Constants.INPUT_BILL_ID);
            boolean existed = false;
            String id = scanner.nextLine();
            for (Bill bill : billBusiness.getBillList()) {
                if (bill.getId().equals(id)) {
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
     * Show bill list to screen
     *
     */
    public void showBillList() {
        System.out.println("-------------------BILL LIST----------------------");
        for (Bill bill : billBusiness.getBillList()) {
            System.out.println("# Bill Id: " + bill.getId() + "\t" + bill.getOrderDate());
            System.out.format("%5s | ", "ID");
            System.out.format("%10s | ", "Item");
            System.out.format("%10s | ", "Price");
            System.out.format("%10s | ", "Quantity");
            System.out.format("%11s%n", "Total");

            for (BillItem billItem : bill.getBillItemList()) {
                System.out.format("%5s | ", billItem.getMenuItem().getId());
                System.out.format("%10s | ", billItem.getMenuItem().getName());
                System.out.format("%10.1f | ", billItem.getMenuItem().getPrice());
                System.out.format("%10s | ", billItem.getQuantity());
                System.out.format("%10.1f$%n", billItem.getPriceBillItem());
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Subtotal: " + bill.getTotalPrice());

        }

    }

    /**
     * Add a bill item to bill in the list of bill
     */
    public void addBillItem() {
        String billId = inputExistedID();
        menuManagementGUI.showMenuList();
        String menuItemId = menuManagementGUI.inputExistedId();
        int quantity = inputQuantity();

        try {
            billBusiness.addBillItem(billId, menuItemId, quantity);
        } catch (IOException e) {
            System.out.println("Failed to add bill item");
        }
    }

    /**
     * delete a bill item in a bill
     */
    private void deleteBillItem() {
        String billId = inputExistedID();
        Bill bill = billBusiness.getBillById(billId);
        showBill(bill);
        String menuItemId = menuManagementGUI.inputExistedId();
        try {
            billBusiness.deleteBillItem(billId, menuItemId);
        } catch (IOException e) {
            System.out.println("Failed to delete bill item");
        }
    }

    /**
     * Show a bill
     *
     * @param bill : bill to show
     */
    private void showBill(Bill bill) {
        System.out.println("-------------------BILL " + bill.getId() + "----------------------");
        System.out.format("%5s | ", "ID");
        System.out.format("%10s | ", "Item");
        System.out.format("%10s | ", "Price");
        System.out.format("%10s | ", "Quantity");
        System.out.format("%11s%n", "Total");

        for (BillItem billItem : bill.getBillItemList()) {
            System.out.format("%5s | ", billItem.getMenuItem().getId());
            System.out.format("%10s | ", billItem.getMenuItem().getName());
            System.out.format("%10.1f | ", billItem.getMenuItem().getPrice());
            System.out.format("%10s | ", billItem.getQuantity());
            System.out.format("%10.1f$%n", billItem.getPriceBillItem());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Subtotal: " + bill.getTotalPrice());
    }

    /**
     * Clear bill items in a bill
     */
    private void clearBill() {
        String billId = inputExistedID();
        try {
            billBusiness.clearBill(billId);
        } catch (IOException e) {
            System.out.println("Failed to clear bill" + e.getMessage());
        }
    }

    /**
     * Show option menu to screen
     */
    public void showOptionMenu() {
        System.out.println("--------BILL MANAGEMENT-------");
        System.out.println("1. Show Bill List");
        System.out.println("2. Create New Bill");
        System.out.println("3. Update Bill");
        System.out.println("4. Delete Bill");
        System.out.println("5. Add Bill Item To Bill");
        System.out.println("6. Delete Bill Item");
        System.out.println("7. Clear bill ");
        System.out.println("8. Total Price Of Bill List");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.print("Please choose: ");
    }

}
