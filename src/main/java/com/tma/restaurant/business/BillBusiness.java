package main.java.com.tma.restaurant.business;

import main.java.com.tma.restaurant.model.MenuItem;
import main.java.com.tma.restaurant.dal.BillDAL;
import main.java.com.tma.restaurant.model.Bill;
import main.java.com.tma.restaurant.model.BillItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * BillBus class
 * (Business Logic Layer)
 *
 * @author intern.npqhuy
 */
public class BillBusiness {
    private BillDAL billDAL;
    private MenuBusiness menuBusiness;
    private BillItemBusiness billItemBusiness;
    private List<Bill> billList;

    /**
     * Init BillDAL object
     * Init Menu Business
     * Read bill list from file
     */
    public BillBusiness() {
        billDAL = new BillDAL();
        menuBusiness = new MenuBusiness();
        billItemBusiness = new BillItemBusiness();
        billList = billDAL.read();
    }

    /**
     * Create a menuItem
     * Create a Bill
     * Add bill to bill list
     * Write bill list to file
     *
     * @param id : id of the bill want to add
     * @param orderDate : order date of the menu want to add
     */
    public void addBill(String id, Date orderDate) throws IOException {
        Bill bill = new Bill(id, orderDate);

        billList.add(bill);
        billDAL.write(billList);
    }

    /**
     * Update bill information in bill list
     *
     * @param id
     * @param menuItem
     * @param quantity
     */
    public void updateBill(String id, MenuItem menuItem, int quantity) throws IOException {
        if (quantity == 0) {
            deleteBillItem(id, menuItem.getId());
        } else {
            boolean check = false;
            for (Bill bill : billList) {
                if (bill.getId().equals(id)) {
                    for (BillItem billItem : bill.getBillItemList()) {
                        if (billItem.getMenuItem().getId().equals(menuItem.getId())) {
                            check = true;
                            billItem.setQuantity(quantity);
                        }
                    }
                    if (!check) {
                        bill.getBillItemList().add(new BillItem(menuItem, quantity));
                    }
                }
            }
            billDAL.write(billList);
        }
    }

    /**
     * Delete bill from bill list
     *
     * @param id : id of the bill want to delete
     */
    public void deleteBill(String id) throws IOException {
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
            totalPrice += bill.getTotalPrice();
        }
        return totalPrice;
    }

    /**
     * Get the bill list
     *
     * @return the bill list
     */
    public List<Bill> getBillList() {
        billList = billDAL.read();
        return billList;
    }

    /**
     * Get a bill by id
     *
     * @param id : bill id to get
     * @return a bill with id input
     */
    public Bill getBillById(String id) {
        for (Bill bill : billList) {
            if (bill.getId().equals(id)) {
                return bill;
            }
        }
        return null;
    }

    /**
     * Add bill item to the bill
     *
     * @param billId : bill id to add
     * @param menuItemId : menu item id to add
     * @param quantity : quantity of menu item
     */
    public void addBillItem(String billId, String menuItemId, int quantity) throws IOException {
        billList = billItemBusiness.addBillItem(billList, billId, menuItemId, quantity);
        billDAL.write(billList);
    }

    /**
     * Delete a bill item in a bill
     *
     * @param billId : bill id to delete
     * @param menuItemId : menu item id to delete
     */
    public void deleteBillItem(String billId, String menuItemId) throws IOException {
        billList = billItemBusiness.deleteBillItem(billList, billId, menuItemId);
        billDAL.write(billList);
    }

    /**
     * Clear bill items in a bill
     *
     * @param billId : bill id of the bill to clear bill items
     */
    public void clearBill(String billId) throws IOException {
        for (Bill bill : billList) {
            if (bill.getId().equals(billId)) {
                bill.getBillItemList().clear();
            }
        }
        billDAL.write(billList);
    }
}
