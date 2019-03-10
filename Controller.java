import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.fxml.Initializable;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;


public class Controller implements Initializable{

    @FXML
    private TableView<Clothing> tableViewInventory;

    @FXML
    private TableColumn<Product, Integer> productCode;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> quantity;

    @FXML
    private TableColumn<Product, String> price;

    @FXML
    private TableColumn<Product, String> category;

    @FXML
    private TableColumn<Clothing, String> size;

    @FXML
    private TableColumn<Clothing, String> color;

    @FXML
    private TableColumn<Accessories, String> type;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCancel;

    @FXML
    private HBox hboxCategory;

    @FXML
    private Label labelCategory;

    @FXML
    private ComboBox<String> comboboxCategory;

    @FXML
    private HBox hboxName;

    @FXML
    private Label labelProductName;

    @FXML
    private TextField textViewProductName;

    @FXML
    private HBox hboxPrice;

    @FXML
    private Label labelPrice;

    @FXML
    private TextField textFieldPrice;

    @FXML
    private HBox hboxQuantity;

    @FXML
    private Label labelQuantity;

    @FXML
    private Spinner<Integer> spinnerQuantity;

    @FXML
    private Label labelSize;

    @FXML
    private Label labelColor;

    @FXML
    private TextField textFieldSize, textFieldColor;
    
    // @FXML 
    // private TextField textFieldType;

    // @FXML
    // private Label labelType;

    private final Clothing currentProduct = new Clothing();
    private final ObservableList products = FXCollections.observableArrayList();
    private final HashMap<Integer, Clothing> productsMap = new HashMap <>();

    public HashMap<Integer, Clothing> getProductsMap(){
        return this.productsMap;
    }

    public void setProductsMap(HashMap<Integer, Clothing> initialProductsMap){
        products.clear();
        productsMap.clear();
        productsMap.putAll(initialProductsMap);
        products.addAll(initialProductsMap.values());
        lastCode=productsMap.keySet().stream().max(Integer::compare).get();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textViewProductName.setText("Product Name");
        comboboxCategory.getItems().addAll(Consts.CLOTHING, Consts.ACCESSORIES);
        textFieldPrice.setTextFormatter(new TextFormatter<Double>(new DoubleStringConverter()));
        spinnerQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 9999, 1, 1));
        labelColor.setDisable(true);
        labelSize.setDisable(true);
        textFieldColor.setDisable(true);
        textFieldSize.setDisable(true);
        // labelType.setDisable(true);
        // textFieldType.setDisable(true);

        // textFieldPrice.textProperty().addListener(new ChangeListener<String>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> observable, String oldValue, 
        //         String newValue) {
        //         if (!newValue.matches("\\d*[.]?\\d*")) {
        //             textFieldPrice.setText(newValue.replaceAll("[^\\d]||[^.]", ""));
        //         }
        //     }
        // });

        // Validating Price Textfield to take only Double values
        // Ref: https://stackoverflow.com/a/31043122/6013612
        DecimalFormat format = new DecimalFormat( "#.0" );
        textFieldPrice.setTextFormatter( new TextFormatter<>(c ->
        {
            if ( c.getControlNewText().isEmpty() )
                return c;

            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( c.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < c.getControlNewText().length() )
                return null;
            else
                return c;
        }));
        
        comboboxCategory.valueProperty().addListener((ov, oldval, newval) -> {
            
            if(Consts.CLOTHING.equalsIgnoreCase(newval)){
                labelColor.setDisable(false);
                labelSize.setDisable(false);
                textFieldColor.setDisable(false);
                textFieldSize.setDisable(false);
                // labelType.setDisable(true);
                // textFieldType.setDisable(true);
            }else if(Consts.ACCESSORIES.equalsIgnoreCase(newval)){
                // labelType.setDisable(false);
                // textFieldType.setDisable(false);
                labelColor.setDisable(true);
                labelSize.setDisable(true);
                textFieldColor.setDisable(true);
                textFieldSize.setDisable(true);
            }
            
        });

        
        textViewProductName.textProperty().bindBidirectional(currentProduct.productNameProperty());
        comboboxCategory.valueProperty().bindBidirectional(currentProduct.categoryProperty());
        textFieldPrice.textProperty().bindBidirectional(currentProduct.pricePerUnitProperty(), new DoubleStringConverter());
        spinnerQuantity.getValueFactory().valueProperty().bindBidirectional(currentProduct.inventoryCountProperty());
        textFieldSize.textProperty().bindBidirectional(currentProduct.sizeProperty());
        textFieldColor.textProperty().bindBidirectional(currentProduct.colorProperty());
        
        tableViewInventory.setItems(products);
        
        productCode.setCellValueFactory(rowData -> rowData.getValue().productCodeProperty());
        productName.setCellValueFactory(rowData -> rowData.getValue().productNameProperty());
        quantity.setCellValueFactory(rowData -> rowData.getValue().inventoryCountProperty());
        price.setCellValueFactory(rowData -> Bindings.concat("$",rowData.getValue().pricePerUnitProperty()));
        category.setCellValueFactory(rowData -> rowData.getValue().categoryProperty());
        size.setCellValueFactory(rowData -> rowData.getValue().sizeProperty());
        color.setCellValueFactory(rowData -> rowData.getValue().colorProperty());
        // type.setCellValueFactory(rowData -> rowData.getValue().typeProperty());
        

        StringBinding addButtonStringBinding = new StringBinding(){
            {
                super.bind(currentProduct.productCodeProperty());
            }
            @Override
            protected String computeValue() {
                if(currentProduct.getProductCode()==null)
                    return "Add";
                else
                    return "Update";
            }
        };

        buttonAdd.textProperty().bind(addButtonStringBinding);
        buttonAdd.disableProperty().bind(Bindings.greaterThan(3,currentProduct.productNameProperty().length()));
        
        tableViewInventory.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Clothing> observable, Clothing oldVal, Clothing newVal) -> {
            setCurrentProduct(newVal);
        });

        
    }
    Integer lastCode=0;
    @FXML
    private void addActionClicked(ActionEvent event){
        if(currentProduct.getProductCode()==null){
            Clothing c = new Clothing(++lastCode,currentProduct.getProductName(), currentProduct.getInventoryCount(), currentProduct.getPricePerUnit(), currentProduct.getSize(), currentProduct.getColor());
            products.add(c);
            productsMap.put(c.getProductCode(), c);
        } else {
            Clothing c = productsMap.get(currentProduct.getProductCode());
            c.setProductName(currentProduct.getProductName());
            c.setCategory(currentProduct.getCategory());
            c.setInventoryCount(currentProduct.getInventoryCount());
            c.setPricePerUnit(currentProduct.getPricePerUnit());
            c.setSize(currentProduct.getSize());
            c.setColor(currentProduct.getColor());
        }
        setCurrentProduct(null);
    }

    @FXML
    private void cancelActionClicked(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to cancel?");
        alert.setTitle("Cancelling");
        alert.getButtonTypes().remove(0,2);
        alert.getButtonTypes().add(0, ButtonType.YES);
        alert.getButtonTypes().add(1, ButtonType.NO);
        Optional<ButtonType> confirmationResponse =  alert.showAndWait();
        if(confirmationResponse.get() == ButtonType.YES){
            setCurrentProduct(null);
            tableViewInventory.getSelectionModel().clearSelection();   
        }
        
    }

    private void setCurrentProduct(Clothing selectedProduct) {
        if (selectedProduct!=null){
            currentProduct.setProductCode(selectedProduct.getProductCode());
            currentProduct.setProductName(selectedProduct.getProductName());
            currentProduct.setCategory(selectedProduct.getCategory());
            currentProduct.setInventoryCount(selectedProduct.getInventoryCount());
            currentProduct.setPricePerUnit(selectedProduct.getPricePerUnit());
            currentProduct.setSize(selectedProduct.getSize());
            currentProduct.setColor(selectedProduct.getColor());
        } else {
            currentProduct.setProductCode(null);
            currentProduct.setProductName("");
            currentProduct.setCategory("");
            currentProduct.setInventoryCount(0);
            currentProduct.setPricePerUnit(0.0);
            currentProduct.setSize("");
            currentProduct.setColor("");
        }
    }

    
}
