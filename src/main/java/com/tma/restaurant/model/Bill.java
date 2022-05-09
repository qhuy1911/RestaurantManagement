package main.java.com.tma.restaurant.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Bill class
 * implements Serializable
 *
 * @author intern.npqhuy
 */
public class Bill implements Serializable {
    private String id;
    private List<BillItem> billItemList;
    private Date orderDate;
    private float totalPrice;

    public Bill(String id, Date orderDate) {
        this.id = id;
        billItemList = new ArrayList<>();
        this.orderDate = orderDate;
    }

    /**
     * Get id of the menu
     *
     * @return id of the menu
     */
    public String getId() {
        return id;
    }

    /**
     * Set id of the menu
     *
     * @param id : the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get order date of the menu
     *
     * @return order date of the menu
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set order date of the menu
     *
     * @param orderDate : the order date to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<BillItem> getBillItemList() {
        return billItemList;
    }

    public void setBillItemList(List<BillItem> billItemList) {
        this.billItemList = billItemList;
    }

    public float getTotalPrice() {
        totalPrice = calculateSubTotal();
        return totalPrice;
    }

    public float calculateSubTotal () {
        float total = 0;
        for (BillItem billItem : billItemList) {
            total += billItem.getPriceBillItem();
        }
        return total;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addBillItem(BillItem billItem) {
        this.billItemList.add(billItem);
    }

    public void removeBillItem(BillItem billItem) {
        this.billItemList.remove(billItem);
    }
}
