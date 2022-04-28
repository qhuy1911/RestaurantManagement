package com.tma.restaurant.DTO;

import java.io.Serializable;

/**
 * Menu abstract class
 * implements Serializable interface
 *
 * @author intern.npqhuy
 */
public abstract class Menu implements Serializable {
    private String id;
    private String name;
    private String description;
    private String image;
    private float price;

    /**
     * Init Menu object
     *
     * @param id : the id of the menu
     * @param name : the name of the menu
     * @param description : the description of the menu
     * @param image : the image of the menu
     * @param price : the price of the menu
     */
    public Menu(String id, String name, String description, String image, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
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
     * Get name of the menu
     *
     * @return name of the menu
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the menu
     *
     * @param name : the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of the menu
     *
     * @return description of the menu
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of the menu
     *
     * @param description : the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get image of the menu
     *
     * @return image of the menu
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image of the menu
     *
     * @param image : the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get price of the menu
     *
     * @return price of the menu
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set price of the menu
     *
     * @param price : the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
