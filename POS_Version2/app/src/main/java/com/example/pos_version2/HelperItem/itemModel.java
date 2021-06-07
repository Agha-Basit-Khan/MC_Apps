package com.example.pos_version2.HelperItem;

public class itemModel {
    private int id;
    private String name;
    private String description;
    private String amount;
    private String quantity;

    public itemModel() {
    }

    public itemModel(int id, String name, String description, String amount, String quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.quantity = quantity;
    }

    public itemModel(String name, String description, String amount, String quantity) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.quantity = quantity;
    }

    public itemModel(String name, String description, String amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}