import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;


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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.fxml.Initializable;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;


public class Controller implements Initializable{

    @FXML
    private TableView<Product> tableViewInventory;

    @FXML
    private TableColumn<Product, Integer> productCode;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Integer> quantity;

    @FXML
    private TableColumn<Product, Double> price;

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
    private Label labelProductType;

    @FXML
    private ComboBox<String> comboboxProductType;

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
    
    @FXML 
    private TextField textFieldType;

    @FXML
    private Label labelType;

    @FXML
    private Label labelCategory;

    @FXML
    private TextField textFieldCategory;

    private Product currentProduct = null;
    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final HashMap<Integer, Product> productsMap = new HashMap <>();

    public HashMap<Integer, Product> getProductsMap(){
        return this.productsMap;
    }

    public void setProductsMap(HashMap<Integer, Product> initialProductsMap){
        products.clear();
        productsMap.clear();
        productsMap.putAll(initialProductsMap);
        products.addAll(initialProductsMap.values());
        lastCode=productsMap.keySet().stream().max(Integer::compare).get();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboboxProductType.getItems().addAll(Consts.CLOTHING, Consts.ACCESSORIES);
        
        textFieldPrice.setTextFormatter(new TextFormatter<Double>(new DoubleStringConverter()));
        spinnerQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 9999, 1, 1));
        

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
        
        comboboxProductType.valueProperty().addListener((ov, oldval, newval) -> {
            
            if(Consts.CLOTHING.equalsIgnoreCase(newval)){
                currentProduct = new Clothing();
                labelType.setDisable(true);
                textFieldType.setDisable(true);
                labelColor.setDisable(false);
                labelSize.setDisable(false);
                textFieldColor.setDisable(false);
                textFieldSize.setDisable(false);

                }else if(Consts.ACCESSORIES.equalsIgnoreCase(newval)){
                currentProduct = new Accessories();
                labelColor.setDisable(true);
                labelSize.setDisable(true);
                textFieldColor.setDisable(true);
                textFieldSize.setDisable(true);
                labelType.setDisable(false);
                textFieldType.setDisable(false);

                //accessory
            }
            
        });
        comboboxProductType.getSelectionModel().selectFirst();

        if(comboboxProductType.getValue().equalsIgnoreCase(Consts.CLOTHING)){
            currentProduct = new Clothing();

            //clothing
        }else if(comboboxProductType.getValue().equalsIgnoreCase(Consts.ACCESSORIES)){
            currentProduct=new Accessories();
            //accessory
        }
        


        tableViewInventory.setItems(products);

        productCode.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productCode"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("inventoryCount"));
        price.setCellValueFactory(new PropertyValueFactory<Product, Double>("pricePerUnit"));
        category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
        size.setCellValueFactory(new PropertyValueFactory<Clothing, String>("size"));
        color.setCellValueFactory(new PropertyValueFactory<Clothing, String>("color"));
        type.setCellValueFactory(new PropertyValueFactory<Accessories, String>("type"));



//        StringBinding addButtonStringBinding = new StringBinding(){
//            {
//                super.bind(currentProduct.productCodeProperty());
//            }
//            @Override
//            protected String computeValue() {
//                if(currentProduct.getProductCode()==null)
//                    return "Add";
//                else
//                    return "Update";
//            }
//        };

//        buttonAdd.textProperty().bind(addButtonStringBinding);
//        buttonAdd.disableProperty().bind(Bindings.greaterThan(3,currentProduct.productNameProperty().length()));
        
        tableViewInventory.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) -> {
            
            setCurrentProduct(newVal);
        });

        
    }
    Integer lastCode=0;
    @FXML
    private void addActionClicked(ActionEvent event){
        if(comboboxProductType.getValue().equalsIgnoreCase(Consts.CLOTHING)){
            currentProduct = new Clothing(++lastCode,
                    textViewProductName.getText(),
                    spinnerQuantity.getValue(),
                    Double.parseDouble(textFieldPrice.getText()),
                    textFieldSize.getText(),
                    textFieldColor.getText(),
                    textFieldCategory.getText());
        }else if(comboboxProductType.getValue().equalsIgnoreCase(Consts.ACCESSORIES)){
            currentProduct = new Accessories(++lastCode,
                    textViewProductName.getText(),
                    spinnerQuantity.getValue(),
                    Double.parseDouble(textFieldPrice.getText()),
                    textFieldType.getText(),
                    textFieldCategory.getText());
        }
        products.add(currentProduct);
        productsMap.put(currentProduct.getProductCode(), currentProduct);
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

    private void setCurrentProduct(Product selectedProduct) {
        System.out.println("SetCurrentProduct");
        if (selectedProduct!=null){
            System.out.println("SetCurrentProduct: If not null");
            if(selectedProduct instanceof Clothing){
                System.out.println("SetCurrentProduct: Clothing");
                currentProduct = new Clothing();
                
                //clothing
                
                System.out.println("Size=>"+((Clothing)selectedProduct).getSize());
                
                ((Clothing)currentProduct).setSize(((Clothing)selectedProduct).getSize());
                ((Clothing)currentProduct).setColor(((Clothing)selectedProduct).getColor());
                System.out.println("SetCurrentProduct: Clothing END");
            }else if(selectedProduct instanceof Accessories){
                System.out.println("SetCurrentProduct: Accessories");
                currentProduct = new Accessories();
                //accessory
                ((Accessories)currentProduct).setType(((Accessories)selectedProduct).getType());
                System.out.println("SetCurrentProduct: Accesories END");
            }
            
            currentProduct.setProductCode(selectedProduct.getProductCode());
            currentProduct.setProductName(selectedProduct.getProductName());
            currentProduct.setCategory(selectedProduct.getCategory());
            currentProduct.setInventoryCount(selectedProduct.getInventoryCount());
            currentProduct.setPricePerUnit(selectedProduct.getPricePerUnit());
            System.out.println("SetCurrentProduct: If no null END");
        } else {
            System.out.println("SetCurrentProduct: If null");
            //default is selected as Clothing
            currentProduct= new Clothing();
            currentProduct.setProductCode(null);
            currentProduct.setProductName("");
            currentProduct.setCategory("");
            currentProduct.setInventoryCount(0);
            currentProduct.setPricePerUnit(0.0);
            ((Clothing)currentProduct).setSize("");
            ((Clothing)currentProduct).setColor("");
            clearAllFields();

        }

    }

    void clearAllFields(){
        textViewProductName.setText("");
        textFieldCategory.setText("");
        textFieldType.setText("");
        textFieldColor.setText("");
        textFieldSize.setText("");
        textFieldPrice.setText("");
        spinnerQuantity.getValueFactory().setValue(1);
    }

    
}