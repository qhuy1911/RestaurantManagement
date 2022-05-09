package main.java.com.tma.restaurant.business;

import main.java.com.tma.restaurant.dal.BillDAL;
import main.java.com.tma.restaurant.model.Bill;
import main.java.com.tma.restaurant.model.BillItem;
import main.java.com.tma.restaurant.model.MenuItem;

import java.io.IOException;
import java.util.List;

/**
 * BillItemBus class
 * (Business Logic Layer)
 *
 * @author intern.npqhuy
 */
public class BillItemBusiness {
    private MenuBusiness menuBusiness;
    
    public BillItemBusiness() {
        menuBusiness = new MenuBusiness();
    }

    public List<Bill> addBillItem(List<Bill> billList, String billId, String menuItemId, int quantity) throws IOException {
        boolean check = false;
        MenuItem menuItem = menuBusiness.getMenuById(menuItemId);
        for (Bill bill : billList) {
            if (bill.getId().equals(billId)) {
                for (BillItem billItem : bill.getBillItemList()) {
                    if (billItem.getMenuItem().getId().equals(menuItemId)) {
                        check = true;
                        billItem.setQuantity(billItem.getQuantity() + quantity);
                    }
                }
                if (!check) {
                    bill.getBillItemList().add(new BillItem(menuItem, quantity));
                }
            }
        }
        return billList;
    }

    public List<Bill> deleteBillItem(List<Bill> billList, String billId, String menuItemId) {
        BillItem item = null;
        for (Bill bill : billList) {
            if (bill.getId().equals(billId)) {
                for (BillItem billItem : bill.getBillItemList()) {
                    if (billItem.getMenuItem().getId().equals(menuItemId)) {
                        item = billItem;
                    }
                }
                bill.getBillItemList().remove(item);
            }
        }
        return billList;
    }
}
