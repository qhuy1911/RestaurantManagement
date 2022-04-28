package com.tma.restaurant.BUS;

import com.tma.restaurant.DAL.BillDAL;
import com.tma.restaurant.DTO.Bill;
import com.tma.restaurant.DTO.Menu;
import com.tma.restaurant.DTO.MenuItem;

import java.util.Date;
import java.util.List;

/**
 * BillBus class
 * (Business Logic Layer)
 *
 * @author intern.npqhuy
 */
public class BillBUS {
    private BillDAL billDAL;
    private List<Bill> billList;

    /**
     * Init BillDAL object
     * Read bill list from file
     */
    public BillBUS() {
        billDAL = new BillDAL();
        billList = billDAL.read();
    }

    /**
     * Create a menuItem
     * Create a Bill
     * Add bill to bill list
     * Write bill list to file
     *
     * @param id : id of the bill want to add
     * @param menu : menu of the menu item want to add
     * @param quantity : quantity of the menu want to add
     * @param orderDate : order date of the menu want to add
     */
    public void add(String id, Menu menu, int quantity, Date orderDate) {
        MenuItem menuItem = new MenuItem(menu, quantity);
        Bill bill = new Bill(id, menuItem, orderDate);

        billList.add(bill);
        billDAL.write(billList);
    }

    /**
     * Update bill information in bill list
     *
     * @param id
     * @param menu
     * @param quantity
     * @param orderDate
     */
    public void update(String id, Menu menu, int quantity, Date orderDate) {
        for (Bill bill : billList) {
            if (bill.getId().equals(id)) {
                bill.setMenuItem(new MenuItem(menu, quantity));
                bill.setOrderDate(orderDate);
            }
        }
        billDAL.write(billList);
    }

    /**
     * Delete bill from bill list
     *
     * @param id : id of the bill want to delete
     */
    public void delete(String id) {
        Bill deleteBill = null;
        for (Bill bill : billList) {
            if (bill.getId().equals(id)) {
                deleteBill = bill;
            }
        }
        billList.remove(deleteBill);
        billDAL.write(billList);
    }

    /**
     * Calculate total price of the bill list
     *
     * @return total price of the bill list
     */
    public float getTotalPriceOfBillList() {
        float totalPrice = 0;
        for (Bill bill : billList) {
            totalPrice += bill.getMenuItem().getTotal();
        }
        return totalPrice;
    }

    /**
     * Get the bill list
     *
     * @return the bill list
     */
    public List<Bill> getBillList() {
        return billList;
    }
}
