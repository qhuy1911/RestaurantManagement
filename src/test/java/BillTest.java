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
    @Before
    public void setUp() throws Exception {
        MenuItem softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
        MenuItem alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
        MenuItem breakfast = new BreakfastMenuItem("3", "Bread", "Breakfast", "bread.png", 15);
        MenuItem lunch = new LunchMenuItem("4", "Rice", "Lunch", "rice.png", 30);
        MenuItem dinner = new DinnerMenuItem("5", "Beef", "Dinner", "beef.png", 50);

        Bill bill1 = new Bill("1", new Date());
        Bill bill2 = new Bill("2", new Date());
        Bill bill3 = new Bill("3", new Date());
        Bill bill4 = new Bill("4", new Date());
        Bill bill5 = new Bill("5", new Date());

        billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);
        billList.add(bill3);
        billList.add(bill4);
        billList.add(bill5);
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

//    @Test
//    public void testQuantity() {
//        for (Bill bill : billList) {
//            Assert.assertNotNull(bill.getMenuItem());
//        }
//
//        Assert.assertEquals(8, billList.get(0).getMenuItem().getQuantity());
//        Assert.assertEquals(2, billList.get(1).getMenuItem().getQuantity());
//        Assert.assertEquals(4, billList.get(2).getMenuItem().getQuantity());
//        Assert.assertEquals(3, billList.get(3).getMenuItem().getQuantity());
//        Assert.assertEquals(2, billList.get(4).getMenuItem().getQuantity());
//    }

//    @Test
//    public void testTotalOfABill() {
//        for (Bill bill : billList) {
//            Assert.assertNotNull(bill.getMenuItem().getPriceBillItem());
//        }
//
//        Assert.assertEquals(70, billList.get(0).getMenuItem().getPriceBillItem(), 0.0);
//        Assert.assertEquals(80, billList.get(1).getMenuItem().getPriceBillItem(), 0.0);
//        Assert.assertEquals(60, billList.get(2).getMenuItem().getPriceBillItem(), 0.0);
//        Assert.assertEquals(90, billList.get(3).getMenuItem().getPriceBillItem(), 0.0);
//        Assert.assertEquals(100, billList.get(4).getMenuItem().getPriceBillItem(), 0.0);
//    }
//
//    @Test
//    public void testTotalOfBillList() {
//        double totalPrice = 0;
//        for (Bill bill : billList) {
//            totalPrice += bill.getMenuItem().getPriceBillItem();
//        }
//
//        Assert.assertEquals(400, totalPrice, 0.0);
//    }

    @Test
    public void testOrderDate() {
        for (Bill bill : billList) {
            Assert.assertNotNull(bill.getOrderDate());
        }
    }
}