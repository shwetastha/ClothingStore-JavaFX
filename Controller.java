import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Observable;
import java.util.ResourceBundle;

import com.sun.javafx.binding.StringFormatter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
import javafx.fxml.Initializable;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textViewProductName.setText("Product Name");
        comboboxCategory.getItems().addAll(Consts.CLOTHING, Consts.ACCESSORIES);
        textFieldPrice.setTextFormatter(new TextFormatter<Double>(new DoubleStringConverter()));
        spinnerQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 1, 1));
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
        
        products.addAll(
        new Clothing("Brown Pants", 5, 15.4, "M", "Brown"),
        new Clothing("White Shirts", 3, 10.4, "M", "White"));

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
