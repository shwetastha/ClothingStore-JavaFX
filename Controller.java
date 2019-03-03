 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class Controller {
    @FXML private Text actiontarget;
    
    @FXML protected void handleAddExpenses(ActionEvent event) {
        actiontarget.setText("AddExpenses");
    }

    @FXML protected void handleShowReport(ActionEvent event) {
        actiontarget.setText("ShowReport");
    }

}