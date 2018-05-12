package sample;

import javafx.beans.property.*;

public class MusicData {
    private StringProperty article;
    private StringProperty artist;
    private FloatProperty price;
    private IntegerProperty quantity;
    private StringProperty mediaType;
    private StringProperty type;
    private StringProperty albumName;
    private StringProperty releaseDate;

    public MusicData(String article, String mediaType, Float price, Integer quantity, String artist, String album_name, String type, String release_date) {
        this.article = new SimpleStringProperty(article);
        this.mediaType = new SimpleStringProperty(mediaType);
        this.price = new SimpleFloatProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.artist = new SimpleStringProperty(artist);
        this.albumName = new SimpleStringProperty(album_name);
        this.type = new SimpleStringProperty(type);
        this.releaseDate = new SimpleStringProperty(release_date);
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

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
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

    public String getMediaType() {
        return mediaType.get();
    }

    public StringProperty mediaTypeProperty() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType.set(mediaType);
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

    public String getAlbumName() {
        return albumName.get();
    }

    public StringProperty albumNameProperty() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName.set(albumName);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }
}
