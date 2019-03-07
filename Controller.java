import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

public class Controller implements Initializable{

    @FXML
    private TableView<?> tableViewInventory;

    @FXML
    private TableColumn<?, ?> productCode;

    @FXML
    private TableColumn<?, ?> productName;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableColumn<?, ?> price;

    @FXML
    private TableColumn<?, ?> category;

    @FXML
    private TableColumn<?, ?> size;

    @FXML
    private TableColumn<?, ?> color;

    @FXML
    private TableColumn<?, ?> type;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textViewProductName.setText("Descriptive Name of the Product");
        comboboxCategory.getItems().addAll("Clothing", "Accessories");
        textFieldPrice.setTextFormatter(new TextFormatter<Double>(new DoubleStringConverter()));
        spinnerQuantity.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 1, 1));
    }
}
