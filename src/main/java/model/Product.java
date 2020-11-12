package model;

public class Product {
    private String name,color,description,category;
    private int price,quantity,category_id,id;

    public Product() {
    }

    public Product(String name, String color, String category, int price, int quantity, int id) {
        this.name = name;
        this.color = color;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public Product(String name, String color, int price, int quantity, int category_id, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
    }

    public Product(String name, String color, String description, String category, int price, int quantity, int category_id, int id) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
        this.id = id;
    }

    public Product(String name, String color, String description, int price, int quantity, int category_id, int id) {
        this.name = name;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category_id = category_id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
