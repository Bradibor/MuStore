package sample;

import javafx.beans.property.*;

public class ItemData {
    private StringProperty article;
    private StringProperty type;
    private FloatProperty price;
    private IntegerProperty quantity;
    private StringProperty name;

    public ItemData(String article, String type, float price, int quantity, String name) {
        this.article = new SimpleStringProperty(article);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.name = new SimpleStringProperty(name);
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

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
