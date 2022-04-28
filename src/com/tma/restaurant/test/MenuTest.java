package com.tma.restaurant.test;

import com.tma.restaurant.DTO.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {
    List<Menu> menuList;

    @Before
    public void init() {
        Menu softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
        Menu alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
        Menu breakfast = new BreakfastMenu("3", "Bread", "Breakfast", "bread.png", 15);
        Menu lunch = new LunchMenu("4", "Rice", "Lunch", "rice.png", 30);
        Menu dinner = new DinnerMenu("5", "Beef", "Dinner", "beef.png", 50);

        menuList = new ArrayList<>();
        menuList.add(softDrink);
        menuList.add(alcohol);
        menuList.add(breakfast);
        menuList.add(lunch);
        menuList.add(dinner);
    }

    @After
    public void teardown() {
        menuList.clear();
    }

    @Test
    public void testSizeOfList() {
        Assert.assertEquals(5, menuList.size());
    }

    @Test
    public void testId() {
        for (Menu menu : menuList) {
            Assert.assertNotNull(menu.getId());
        }

        Assert.assertEquals("1", menuList.get(0).getId());
        Assert.assertEquals("2", menuList.get(1).getId());
        Assert.assertEquals("3", menuList.get(2).getId());
        Assert.assertEquals("4", menuList.get(3).getId());
        Assert.assertEquals("5", menuList.get(4).getId());
    }

    @Test
    public void testName() {
        for (Menu menu : menuList) {
            Assert.assertNotNull(menu.getDescription());
        }

        Assert.assertEquals("Coca", menuList.get(0).getName());
        Assert.assertEquals("Red wine", menuList.get(1).getName());
        Assert.assertEquals("Bread", menuList.get(2).getName());
        Assert.assertEquals("Rice", menuList.get(3).getName());
        Assert.assertEquals("Beef", menuList.get(4).getName());
    }

    @Test
    public void testDescription() {
        for (Menu menu : menuList) {
            Assert.assertNotNull(menu.getName());
        }

        Assert.assertEquals("Soft Drink", menuList.get(0).getDescription());
        Assert.assertEquals("Alcohol", menuList.get(1).getDescription());
        Assert.assertEquals("Breakfast", menuList.get(2).getDescription());
        Assert.assertEquals("Lunch", menuList.get(3).getDescription());
        Assert.assertEquals("Dinner", menuList.get(4).getDescription());
    }

    @Test
    public void testImage() {
        for (Menu menu : menuList) {
            Assert.assertNotNull(menu.getImage());
        }

        Assert.assertEquals("coca.png", menuList.get(0).getImage());
        Assert.assertEquals("wine.png", menuList.get(1).getImage());
        Assert.assertEquals("bread.png", menuList.get(2).getImage());
        Assert.assertEquals("rice.png", menuList.get(3).getImage());
        Assert.assertEquals("beef.png", menuList.get(4).getImage());
    }

    @Test
    public void testPrice() {
        for (Menu menu : menuList) {
            Assert.assertNotNull(menu.getPrice());
        }

        Assert.assertEquals(10, menuList.get(0).getPrice(), 0.0);
        Assert.assertEquals(40, menuList.get(1).getPrice(), 0.0);
        Assert.assertEquals(15, menuList.get(2).getPrice(), 0.0);
        Assert.assertEquals(30, menuList.get(3).getPrice(), 0.0);
        Assert.assertEquals(50, menuList.get(4).getPrice(), 0.0);
    }
}