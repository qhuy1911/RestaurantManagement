package test.java;

import main.java.com.tma.restaurant.model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillTest {
    List<Bill> billList;
    Bill bill1, bill2, bill3;
    @Before
    public void setUp() throws Exception {
        MenuItem softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
        MenuItem alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
        MenuItem breakfast = new BreakfastMenuItem("3", "Bread", "Breakfast", "bread.png", 15);
        MenuItem lunch = new LunchMenuItem("4", "Rice", "Lunch", "rice.png", 30);
        MenuItem dinner = new DinnerMenuItem("5", "Beef", "Dinner", "beef.png", 50);

        bill1 = new Bill("1", new Date());
        bill1.getBillItemList().add(new BillItem(softDrink, 7));
        bill1.getBillItemList().add(new BillItem(breakfast, 2));

        bill2 = new Bill("2", new Date());
        bill2.getBillItemList().add(new BillItem(alcohol, 2));
        bill2.getBillItemList().add(new BillItem(dinner, 2));

        bill3 = new Bill("3", new Date());
        bill3.getBillItemList().add(new BillItem(breakfast, 4));
        bill3.getBillItemList().add(new BillItem(lunch, 4));

        billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);
        billList.add(bill3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSizeOfBill() {
        Assert.assertEquals(5, billList.size());
    }

    @Test
    public void testId() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getId());
        }

        Assert.assertEquals("1", billList.get(0).getId());
        Assert.assertEquals("2", billList.get(1).getId());
        Assert.assertEquals("3", billList.get(2).getId());
        Assert.assertEquals("4", billList.get(3).getId());
        Assert.assertEquals("5", billList.get(4).getId());
    }

    @Test
    public void testQuantity() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getBillItemList());
        }

        Assert.assertEquals(7, bill1.getBillItemList().get(0).getQuantity());
        Assert.assertEquals(2, bill1.getBillItemList().get(1).getQuantity());

        Assert.assertEquals(2, bill2.getBillItemList().get(0).getQuantity());
        Assert.assertEquals(2, bill2.getBillItemList().get(1).getQuantity());

        Assert.assertEquals(4, bill3.getBillItemList().get(0).getQuantity());
        Assert.assertEquals(4, bill3.getBillItemList().get(1).getQuantity());
    }

    @Test
    public void testPriceBillItem() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getBillItemList());
        }

        Assert.assertEquals(70, bill1.getBillItemList().get(0).getPriceBillItem(), 0.0);
        Assert.assertEquals(30, bill1.getBillItemList().get(1).getPriceBillItem(), 0.0);

        Assert.assertEquals(80, bill2.getBillItemList().get(0).getPriceBillItem(), 0.0);
        Assert.assertEquals(100, bill2.getBillItemList().get(1).getPriceBillItem(), 0.0);

        Assert.assertEquals(60, bill3.getBillItemList().get(0).getPriceBillItem(), 0.0);
        Assert.assertEquals(120, bill3.getBillItemList().get(1).getPriceBillItem(), 0.0);
    }

    @Test
    public void testTotalOfABill() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getTotalPrice());
        }

        Assert.assertEquals(100, billList.get(0).getTotalPrice(), 0.0);
        Assert.assertEquals(180, billList.get(1).getTotalPrice(), 0.0);
        Assert.assertEquals(180, billList.get(2).getTotalPrice(), 0.0);
    }

    @Test
    public void testTotalOfBillList() {
        double totalPrice = 0;
        for (Bill bill : billList) {
            totalPrice += bill.getTotalPrice();
        }

        Assert.assertEquals(460, totalPrice, 0.0);
    }

    @Test
    public void testOrderDate() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getOrderDate());
        }
    }
}