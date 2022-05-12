package test.java;

import main.java.com.tma.restaurant.model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class MenuItemTest {
    List<MenuItem> menuItemList;

    @Before
    public void init() {
        MenuItem softDrink = new SoftDrink("1", "Coca", "Soft Drink", "coca.png", 10);
        MenuItem alcohol = new Alcohol("2", "Red wine", "Alcohol", "wine.png", 40);
        MenuItem breakfast = new BreakfastMenuItem("3", "Bread", "Breakfast", "bread.png", 15);
        MenuItem lunch = new LunchMenuItem("4", "Rice", "Lunch", "rice.png", 30);
        MenuItem dinner = new DinnerMenuItem("5", "Beef", "Dinner", "beef.png", 50);

        menuItemList = new ArrayList<>();
        menuItemList.add(softDrink);
        menuItemList.add(alcohol);
        menuItemList.add(breakfast);
        menuItemList.add(lunch);
        menuItemList.add(dinner);
    }

    @After
    public void teardown() {
        menuItemList.clear();
    }

    @Test
    public void testSizeOfList() {
        Assert.assertEquals(5, menuItemList.size());
    }

    @Test
    public void testId() {
        for (MenuItem menuItem : menuItemList) {
            Assert.assertNotNull(menuItem.getId());
        }

        Assert.assertEquals("1", menuItemList.get(0).getId());
        Assert.assertEquals("2", menuItemList.get(1).getId());
        Assert.assertEquals("3", menuItemList.get(2).getId());
        Assert.assertEquals("4", menuItemList.get(3).getId());
        Assert.assertEquals("5", menuItemList.get(4).getId());
    }

    @Test
    public void testName() {
        for (MenuItem menuItem : menuItemList) {
            Assert.assertNotNull(menuItem.getDescription());
        }

        Assert.assertEquals("Coca", menuItemList.get(0).getName());
        Assert.assertEquals("Red wine", menuItemList.get(1).getName());
        Assert.assertEquals("Bread", menuItemList.get(2).getName());
        Assert.assertEquals("Rice", menuItemList.get(3).getName());
        Assert.assertEquals("Beef", menuItemList.get(4).getName());
    }

    @Test
    public void testDescription() {
        for (MenuItem menuItem : menuItemList) {
            Assert.assertNotNull(menuItem.getName());
        }

        Assert.assertEquals("Soft Drink", menuItemList.get(0).getDescription());
        Assert.assertEquals("Alcohol", menuItemList.get(1).getDescription());
        Assert.assertEquals("Breakfast", menuItemList.get(2).getDescription());
        Assert.assertEquals("Lunch", menuItemList.get(3).getDescription());
        Assert.assertEquals("Dinner", menuItemList.get(4).getDescription());
    }

    @Test
    public void testImage() {
        for (MenuItem menuItem : menuItemList) {
            Assert.assertNotNull(menuItem.getImage());
        }

        Assert.assertEquals("coca.png", menuItemList.get(0).getImage());
        Assert.assertEquals("wine.png", menuItemList.get(1).getImage());
        Assert.assertEquals("bread.png", menuItemList.get(2).getImage());
        Assert.assertEquals("rice.png", menuItemList.get(3).getImage());
        Assert.assertEquals("beef.png", menuItemList.get(4).getImage());
    }

    @Test
    public void testPrice() {
        for (MenuItem menuItem : menuItemList) {
            Assert.assertNotNull(menuItem.getPrice());
        }

        Assert.assertEquals(10, menuItemList.get(0).getPrice(), 0.0);
        Assert.assertEquals(40, menuItemList.get(1).getPrice(), 0.0);
        Assert.assertEquals(15, menuItemList.get(2).getPrice(), 0.0);
        Assert.assertEquals(30, menuItemList.get(3).getPrice(), 0.0);
        Assert.assertEquals(50, menuItemList.get(4).getPrice(), 0.0);
    }
}