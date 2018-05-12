package sample;

import javafx.beans.property.*;

public class GuitarData {
    private StringProperty article;
    private StringProperty brand;
    private FloatProperty price;
    private IntegerProperty quantity;
    private StringProperty model;
    private StringProperty type;
    private StringProperty stringNumber;
    private StringProperty fretboardMaterial;
    private StringProperty fretNumber;

    public GuitarData(String article, String brand, Float price, Integer quantity, String model, String type, String stringNumber, String fretboardMaterial, String fret_number) {
        this.article = new SimpleStringProperty(article);
        this.brand = new SimpleStringProperty(brand);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.model = new SimpleStringProperty(model);
        this.type = new SimpleStringProperty(type);
        this.stringNumber = new SimpleStringProperty(stringNumber);
        this.fretboardMaterial = new SimpleStringProperty(fretboardMaterial);
        this.fretNumber = new SimpleStringProperty(fret_number);
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

    public String getStringNumber() {
        return stringNumber.get();
    }

    public StringProperty stringNumberProperty() {
        return stringNumber;
    }

    public void setStringNumber(String stringNumber) {
        this.stringNumber.set(stringNumber);
    }

    public String getFretboardMaterial() {
        return fretboardMaterial.get();
    }

    public StringProperty fretboardMaterialProperty() {
        return fretboardMaterial;
    }

    public void setFretboardMaterial(String fretboardMaterial) {
        this.fretboardMaterial.set(fretboardMaterial);
    }

    public String getFretNumber() {
        return fretNumber.get();
    }

    public StringProperty fretNumberProperty() {
        return fretNumber;
    }

    public void setFretNumber(String fretNumber) {
        this.fretNumber.set(fretNumber);
    }
}
