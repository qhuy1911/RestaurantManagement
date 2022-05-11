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

    /**
     * Init Bill Object
     * @param id : id of the bill
     * @param orderDate : orderDate of the bill
     */
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

    /**
     * Get bill item list of the bill
     *
     * @return the list of bill items
     */
    public List<BillItem> getBillItemList() {
        return billItemList;
    }

    /**
     * Set bill item list of the bill
     *
     * @param billItemList : bill item list to set
     */
    public void setBillItemList(List<BillItem> billItemList) {
        this.billItemList = billItemList;
    }

    /**
     * Get total price of the bill
     *
     * @return total price of the bill
     */
    public float getTotalPrice() {
        totalPrice = calculateSubTotal();
        return totalPrice;
    }

    /**
     * Calculate subtotal of the bill
     *
     * @return subtotal of the bill
     */
    public float calculateSubTotal () {
        float total = 0;
        for (BillItem billItem : billItemList) {
            total += billItem.getPriceBillItem();
        }
        return total;
    }

    /**
     * Set total price of the bill
     *
     * @param totalPrice : total price to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
