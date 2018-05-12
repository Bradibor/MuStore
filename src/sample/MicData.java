package sample;

import javafx.beans.property.*;

public class MicData {
    private StringProperty article;
    private StringProperty brand;
    private FloatProperty price;
    private IntegerProperty quantity;
    private StringProperty model;
    private StringProperty type;
    private StringProperty use;

    public MicData(String article, String brand, Float price, Integer quantity, String model, String type, String use) {
        this.article = new SimpleStringProperty(article);
        this.brand = new SimpleStringProperty(brand);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.model = new SimpleStringProperty(model);
        this.type = new SimpleStringProperty(type);
        this.use = new SimpleStringProperty(use);
    }



    public String getArticle() {
        return article.get();
    }

    public StringProperty articleProperty() {
        return article;
    }

    public void setArticle(String article) {
        this.article.set(article);
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public float getPrice() {
        return price.get();
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public String getModel() {
        return model.get();
    }

    public StringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getUse() {
        return use.get();
    }

    public StringProperty useProperty() {
        return use;
    }

    public void setUse(String use) {
        this.use.set(use);
    }
}
