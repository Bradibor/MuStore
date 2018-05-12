package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.StringJoiner;


public class Controller implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private ChoiceBox typeIn;

    @FXML
    private TextField articleIn;

    @FXML
    private TextField priceIn;

    @FXML
    private TextField quantityIn;

    private TextField additional1;
    private TextField additional2;
    private TextField additional3;
    private TextField additional4;
    private TextField additional5;
    private TextField additional6;

    @FXML
    private TableView<ItemData> itemsTable;

    @FXML
    private TableColumn<ItemData, String> articleCol;

    @FXML
    private TableColumn<ItemData, String> nameCol;

    @FXML
    private TableColumn<ItemData, String> typeCol;

    @FXML
    private TableColumn<ItemData, Float> priceCol;

    @FXML
    private TableColumn<ItemData, Integer> quantityCol;

    @FXML
    private TableView<MicData> micTable;

    @FXML
    private TableColumn<MicData, String> micArticleCol;

    @FXML
    private TableColumn<MicData, String> micBrandCol;

    @FXML
    private TableColumn<MicData, String> micModelCol;

    @FXML
    private TableColumn<MicData, String> micTypeCol;

    @FXML
    private TableColumn<MicData, String> micUseCol;

    @FXML
    private TableColumn<MicData, Float> micPriceCol;

    @FXML
    private TableColumn<MicData, Integer> micQuantityCol;

    @FXML
    private TableView<GuitarData> guitarTable;

    @FXML
    private TableColumn<GuitarData, String> guitarArticleCol;

    @FXML
    private TableColumn<GuitarData, String> guitarBrandCol;

    @FXML
    private TableColumn<GuitarData, String> guitarModelCol;

    @FXML
    private TableColumn<GuitarData, String> guitarTypeCol;

    @FXML
    private TableColumn<GuitarData, String> guitarStringNumberCol;

    @FXML
    private TableColumn<GuitarData, String> guitarFretMatCol;

    @FXML
    private TableColumn<GuitarData, String> guitarFretNumberCol;

    @FXML
    private TableColumn<GuitarData, Float> guitarPriceCol;

    @FXML
    private TableColumn<GuitarData, Integer> guitarQuantityCol;

    @FXML
    private TableView<SynthData> synthTable;

    @FXML
    private TableColumn<SynthData, String> synthArticleCol;

    @FXML
    private TableColumn<SynthData, String> synthBrandCol;

    @FXML
    private TableColumn<SynthData, String> synthModelCol;

    @FXML
    private TableColumn<SynthData, Integer> synthKeysNumberCol;

    @FXML
    private TableColumn<SynthData, Integer> synthPresetNumberCol;

    @FXML
    private TableColumn<SynthData, Float> synthPriceCol;

    @FXML
    private TableColumn<SynthData, Integer> synthQuantityCol;

    @FXML
    private TabPane tabs;

    @FXML
    private TableView<MusicData> musicTable;

    @FXML
    private TableColumn<SynthData, String> musicArticleCol;

    @FXML
    private TableColumn<MusicData, String> musicMediaTypeCol;

    @FXML
    private TableColumn<MusicData, String> musicArtistCol;

    @FXML
    private TableColumn<MusicData, String> musicAlbumCol;

    @FXML
    private TableColumn<MusicData, String> musicTypeCol;

    @FXML
    private TableColumn<MusicData, String> musicReleaseDateCol;

    @FXML
    private TableColumn<MusicData, Float> musicPriceCol;

    @FXML
    private TableColumn<MusicData, Integer> musicQuantityCol;

    private dbConnection db;

    private ObservableList<ItemData> data;

    private ObservableList<MicData> micData;

    private ObservableList<GuitarData> guitarData;

    private ObservableList<SynthData> synthData;

    private ObservableList<MusicData> musicData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new dbConnection();
        tabs.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                        String tabId = t1.getId();
                        if(tabId.equals("itemsTab")) loadItemData();
                        else if(tabId.equals("micTab")) loadMicData();
                        else if(tabId.equals("guitarTab")) loadGuitarData();
                        else if(tabId.equals("synthTab")) loadSynthData();
                        else if(tabId.equals("musicTab")) loadMusicData();

                    }
                }
        );
        final ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("Microphone");
        typeList.add("Guitar");
        typeList.add("Synth");
        typeList.add("Music");
        typeIn.setItems(typeList);
        typeIn.valueProperty().addListener(
                new ChangeListener<String>() {
                    @Override public void changed(ObservableValue ov, String t, String t1) {
                        if(t1.equals("Microphone")) {
                             additional1 =  new TextField(){{setPromptText("Brand");}};
                             additional2 =  new TextField(){{setPromptText("Model");}};
                             additional3 =  new TextField(){{setPromptText("Type");}};
                             additional4 =  new TextField(){{setPromptText("Use");}};
                            vBox.getChildren().setAll(
                                additional1,additional2, additional3, additional4
                            );
                        } else if(t1.equals("Guitar")) {
                                additional1 =  new TextField(){{setPromptText("Brand");}};
                                additional2 =  new TextField(){{setPromptText("Model");}};
                                additional3 =  new TextField(){{setPromptText("Type");}};
                                additional4 =  new TextField(){{setPromptText("String Number");}};
                                additional5 =  new TextField(){{setPromptText("Fretboard Material");}};
                                additional6 =  new TextField(){{setPromptText("Fret Number");}};
                                vBox.getChildren().setAll(
                                    additional1, additional2, additional3, additional4, additional5, additional6
                                );
                        } else if(t1.equals("Synth")) {
                            vBox.getChildren().setAll(
                                additional1 = new TextField(){{setPromptText("Brand");}},
                                additional2 = new TextField(){{setPromptText("Model");}},
                                additional3 = new TextField(){{setPromptText("Keys Number");}},
                                additional4 = new TextField(){{setPromptText("Preset Number");}}
                            );
                        } else if(t1.equals("Music")) {
                            vBox.getChildren().setAll(
                                 additional1 = new TextField(){{setPromptText("Media Type");}},
                                 additional2 = new TextField(){{setPromptText("Artist");}},
                                 additional3 = new TextField(){{setPromptText("Album Name");}},
                                 additional4 = new TextField(){{setPromptText("Type");}},
                                 additional5= new TextField(){{setPromptText("Release Date");}}
                            );
                        }
                    }

                }
        );
    }

    @FXML
    private void loadItemData() { ;
        try {
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM ITEM");
            while (rs.next()) {
                String type = rs.getString("type");
                String name;
                String article = rs.getString("article");
                if (type.equals("music")) {
                    ResultSet subResult = conn.createStatement().executeQuery("SELECT * FROM MUSIC WHERE ARTICLE = " + article);
                    subResult.next();
                    name = subResult.getString("artist") + " - " + subResult.getString("album_name");
                } else {
                    ResultSet subResult = conn.createStatement().executeQuery("SELECT * FROM " + type + " WHERE ARTICLE = " + article);
                    subResult.next();
                    name = subResult.getString("brand") + " " + subResult.getString("model");
                }
                this.data.add(new ItemData(article, type, rs.getFloat("price"), rs.getInt("quantity"), name));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.articleCol.setCellValueFactory(new PropertyValueFactory<ItemData, String>("article"));
        this.nameCol.setCellValueFactory(new PropertyValueFactory<ItemData, String>("name"));
        this.priceCol.setCellValueFactory(new PropertyValueFactory<ItemData, Float>("price"));
        this.quantityCol.setCellValueFactory(new PropertyValueFactory<ItemData, Integer>("quantity"));
        this.typeCol.setCellValueFactory(new PropertyValueFactory<ItemData, String>("type"));
        this.itemsTable.setItems(this.data);
    }

    @FXML
    private void loadMicData() {
        try {
            Connection conn = dbConnection.getConnection();
            this.micData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM MICRO");
            while (rs.next()) {
                String article = rs.getString("article");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String use = rs.getString("use");
                Float price;
                Integer quantity;
                ResultSet subResult = conn.createStatement().executeQuery("SELECT PRICE, QUANTITY FROM ITEM WHERE ARTICLE = " + article);
                subResult.next();
                price = subResult.getFloat("price");
                quantity = subResult.getInt("quantity");
                this.micData.add(new MicData(article, brand, price, quantity, model, type, use));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.micArticleCol.setCellValueFactory(new PropertyValueFactory<MicData, String>("article"));
        this.micBrandCol.setCellValueFactory(new PropertyValueFactory<MicData, String>("brand"));
        this.micModelCol.setCellValueFactory(new PropertyValueFactory<MicData, String>("model"));
        this.micTypeCol.setCellValueFactory(new PropertyValueFactory<MicData, String>("type"));
        this.micUseCol.setCellValueFactory(new PropertyValueFactory<MicData, String>("use"));
        this.micPriceCol.setCellValueFactory(new PropertyValueFactory<MicData, Float>("price"));
        this.micQuantityCol.setCellValueFactory(new PropertyValueFactory<MicData, Integer>("quantity"));
        this.micTable.setItems(this.micData);
    }

    @FXML
    private void loadGuitarData() {
        try {
            Connection conn = dbConnection.getConnection();
            this.guitarData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM GUITAR");
            while (rs.next()) {
                String article = rs.getString("article");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String type = rs.getString("type");
                String stringNumber = rs.getString("string_number");
                String fretboardMaterial = rs.getString("fretboard_material");
                String fret_number = rs.getString("fret_number");
                Float price;
                Integer quantity;
                ResultSet subResult = conn.createStatement().executeQuery("SELECT PRICE, QUANTITY FROM ITEM WHERE ARTICLE = " + article);
                subResult.next();
                price = subResult.getFloat("price");
                quantity = subResult.getInt("quantity");
                this.guitarData.add(new GuitarData(article, brand, price, quantity, model, type, stringNumber, fretboardMaterial, fret_number));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.guitarArticleCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("article"));
        this.guitarBrandCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("brand"));
        this.guitarModelCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("model"));
        this.guitarTypeCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("type"));
        this.guitarStringNumberCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("stringNumber"));
        this.guitarFretMatCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("fretboardMaterial"));
        this.guitarFretNumberCol.setCellValueFactory(new PropertyValueFactory<GuitarData, String>("fretNumber"));
        this.guitarPriceCol.setCellValueFactory(new PropertyValueFactory<GuitarData, Float>("price"));
        this.guitarQuantityCol.setCellValueFactory(new PropertyValueFactory<GuitarData, Integer>("quantity"));
        this.guitarTable.setItems(this.guitarData);
    }

    @FXML
    private void loadSynthData() {
        try {
            Connection conn = dbConnection.getConnection();
            this.synthData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM SYNTH");
            while (rs.next()) {
                String article = rs.getString("article");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String keys_number = rs.getString("keys_number");
                String preset_number = rs.getString("preset_number");
                String display = rs.getString("display");
                Float price;
                Integer quantity;
                ResultSet subResult = conn.createStatement().executeQuery("SELECT PRICE, QUANTITY FROM ITEM WHERE ARTICLE = " + article);
                subResult.next();
                price = subResult.getFloat("price");
                quantity = subResult.getInt("quantity");
                this.synthData.add(new SynthData(article, brand, price, quantity, model, keys_number, preset_number, display));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.synthArticleCol.setCellValueFactory(new PropertyValueFactory<SynthData, String>("article"));
        this.synthBrandCol.setCellValueFactory(new PropertyValueFactory<SynthData, String>("brand"));
        this.synthModelCol.setCellValueFactory(new PropertyValueFactory<SynthData, String>("model"));
        this.synthKeysNumberCol.setCellValueFactory(new PropertyValueFactory<SynthData, Integer>("keysNumber"));
        this.synthPresetNumberCol.setCellValueFactory(new PropertyValueFactory<SynthData, Integer>("presetNumber"));
        this.synthPriceCol.setCellValueFactory(new PropertyValueFactory<SynthData, Float>("price"));
        this.synthQuantityCol.setCellValueFactory(new PropertyValueFactory<SynthData, Integer>("quantity"));
        this.synthTable.setItems(this.synthData);
    }

    @FXML
    private void loadMusicData() {
        try {
            Connection conn = dbConnection.getConnection();
            this.musicData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM MUSIC");
            while (rs.next()) {
                String article = rs.getString("article");
                String mediaType = rs.getString("media_type");
                String artist = rs.getString("artist");
                String album_name = rs.getString("album_name");
                String type = rs.getString("type");
                String release_date = rs.getString("release_date");
                Float price;
                Integer quantity;
                ResultSet subResult = conn.createStatement().executeQuery("SELECT PRICE, QUANTITY FROM ITEM WHERE ARTICLE = " + article);
                subResult.next();
                price = subResult.getFloat("price");
                quantity = subResult.getInt("quantity");
                this.musicData.add(new MusicData(article, mediaType, price, quantity, artist, album_name, type, release_date));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.musicArticleCol.setCellValueFactory(new PropertyValueFactory<SynthData, String>("article"));
        this.musicMediaTypeCol.setCellValueFactory(new PropertyValueFactory<MusicData, String>("mediaType"));
        this.musicArtistCol.setCellValueFactory(new PropertyValueFactory<MusicData, String>("artist"));
        this.musicAlbumCol.setCellValueFactory(new PropertyValueFactory<MusicData, String>("albumName"));
        this.musicTypeCol.setCellValueFactory(new PropertyValueFactory<MusicData, String>("type"));
        this.musicReleaseDateCol.setCellValueFactory(new PropertyValueFactory<MusicData, String>("releaseDate"));
        this.musicPriceCol.setCellValueFactory(new PropertyValueFactory<MusicData, Float>("price"));
        this.musicQuantityCol.setCellValueFactory(new PropertyValueFactory<MusicData, Integer>("quantity"));
        this.musicTable.setItems(this.musicData);
    }

    @FXML
    private void addItem(ActionEvent event) {
        System.out.println(typeIn.getValue());
        String type = (String) typeIn.getValue();
        String addSql = "";
        String addItemSql;
        StringJoiner stringJoiner = new StringJoiner(",", "(",")");
        if(type.equals("Microphone")){
                stringJoiner.add(articleIn.getText());
                stringJoiner.add(additional1.getText());
                stringJoiner.add(additional2.getText());
                stringJoiner.add(additional3.getText());
                stringJoiner.add(additional4.getText());
            addSql = "INSERT INTO MICRO (article, brand, model, type, use) " +
                    "VALUES " + stringJoiner.toString() + ";";
            System.out.println(addSql);
        }
        stringJoiner = new StringJoiner(",", "(", ")");
        stringJoiner.add(articleIn.getText());
        stringJoiner.add(quantityIn.getText());
        stringJoiner.add(priceIn.getText());
        addItemSql = "INSER INTO ITEM (article, quantity, price)" + stringJoiner.toString() + ";";
        try {
            Connection conn = dbConnection.getConnection();
            conn.createStatement().execute(addSql);
            conn.createStatement().execute(addItemSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
