package com.tma.restaurant.GUI;

import com.tma.restaurant.BUS.BillBUS;
import com.tma.restaurant.BUS.MenuBUS;
import com.tma.restaurant.DTO.Bill;
import com.tma.restaurant.DTO.Menu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * BillManagementGUI class
 * (Presentation Layer)
 *
 * @author intern.npqhuy
 */
public class BillManagementGUI {
    public Scanner scanner = new Scanner(System.in);
    public MenuBUS menuBus = new MenuBUS();
    public BillBUS billBUS = new BillBUS();

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
                case "1":
                    showBillList(billBUS.getBillList());
                    break;
                case "2":
                    addBill();
                    break;
                case "3":
                    updateBill();
                    break;
                case "4":
                    deleteBill();
                    break;
                case "5":
                    calculateTotalPrice();
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
     * Calculate total price of bill list
     */
    private void calculateTotalPrice() {
        float totalPrice = billBUS.getTotalPriceOfBillList();
        System.out.println("-------Total bill list--------");
        System.out.format("Total price: %15.1f $%n", totalPrice);
    }

    /**
     * Add bill to bill list
     */
    public void addBill() {
        String id = inputID();
        String menuID = inputMenuID();
        Menu menu = menuBus.getMenuById(menuID);
        int quantity = inputQuantity();
        Date orderDate = new Date();

        billBUS.add(id, menu, quantity, orderDate);
    }

    /**
     * Update bill information in bill list
     */
    public void updateBill() {
        String id = inputExistedID();
        String menuID = inputMenuID();
        Menu menu = menuBus.getMenuById(menuID);
        int quantity = inputQuantity();
        Date orderDate = new Date();

        billBUS.update(id, menu, quantity, orderDate);
    }

    /**
     * Delete bill from bill list
     */
    public void deleteBill() {
        String id = inputExistedID();
        billBUS.delete(id);
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
            System.out.print("Input bill id to delete: ");
            boolean check = false;
            String id = scanner.nextLine();
            for (Bill bill : billBUS.getBillList()) {
                if (bill.getId().equals(id)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                return id;
            }
            System.out.println("Invalid ID! Please again...");
        }
    }

    /**
     * Get input quantity of menu item from user
     *
     * @return input quantity from user
     */
    public int inputQuantity() {
        int qty = 0;
        while (true) {
            try {
                System.out.print("Input quantity: ");
                qty = Integer.parseInt(scanner.nextLine());
                return qty;
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity! Quantity must be a number");
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
            System.out.print("Input menu id: ");
            boolean check = false;
            String id = scanner.nextLine();
            for (Menu menu : menuBus.getMenuList()) {
                if (menu.getId().equals(id)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                return id;
            }
            System.out.println("Invalid id! Please again...");
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
            System.out.print("Input bill id: ");
            boolean existed = false;
            String id = scanner.nextLine();
            for (Bill bill : billBUS.getBillList()) {
                if (bill.getId().equals(id)) {
                    existed = true;
                    break;
                }
            }
            if (existed) {
                System.out.println("ID is existed! Please again...");
                continue;
            }
            return id;
        }
    }

    /**
     * Show bill list to screen
     *
     * @param billList : bill list to show
     */
    public void showBillList(List<Bill> billList) {
        System.out.println("---------------------------------------BILL LIST-------------------------------------------");
        System.out.format("%5s | ", "ID");
        System.out.format("%10s | ", "Name");
        System.out.format("%10s | ", "Price");
        System.out.format("%10s | ", "Quantity");
        System.out.format("%30s | ", "Order Date");
        System.out.format("%11s%n", "Total");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Bill bill : billList) {
            System.out.format("%5s | ", bill.getId());
            System.out.format("%10s | ", bill.getMenuItem().getMenu().getName());
            System.out.format("%10.1f | ", bill.getMenuItem().getMenu().getPrice());
            System.out.format("%10s | ", bill.getMenuItem().getQuantity());
            System.out.format("%30s | ", bill.getOrderDate());
            System.out.format("%10.1f$%n", bill.getMenuItem().getTotal());
        }
        System.out.println("-------------------------------------------------------------------------------------------");
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
        System.out.println("5. Total Price Of Bill List");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.print("Please choose: ");
    }

}
