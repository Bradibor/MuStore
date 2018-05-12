package sample;

import javafx.beans.property.*;

public class SynthData {
    private StringProperty article;
    private StringProperty brand;
    private FloatProperty price;
    private IntegerProperty quantity;
    private StringProperty model;
    private StringProperty keysNumber;
    private StringProperty presetNumber;
    private StringProperty display;

    public SynthData(String article, String brand, Float price, Integer quantity, String model, String keys_number, String preset_number, String display) {
        this.article = new SimpleStringProperty(article);
        this.brand = new SimpleStringProperty(brand);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.model = new SimpleStringProperty(model);
        this.keysNumber = new SimpleStringProperty(keys_number);
        this.presetNumber = new SimpleStringProperty(preset_number);
        this.display = new SimpleStringProperty(display);
    }


    public String getArticle() {
        return article.get();
    }

    public String getDisplay() {
        return display.get();
    }

    public StringProperty displayProperty() {
        return display;
    }

    public void setDisplay(String display) {
        this.display.set(display);
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

    public String getKeysNumber() {
        return keysNumber.get();
    }

    public StringProperty keysNumberProperty() {
        return keysNumber;
    }

    public void setKeysNumber(String keysNumber) {
        this.keysNumber.set(keysNumber);
    }

    public String getPresetNumber() {
        return presetNumber.get();
    }

    public StringProperty presetNumberProperty() {
        return presetNumber;
    }

    public void setPresetNumber(String presetNumber) {
        this.presetNumber.set(presetNumber);
    }
}
