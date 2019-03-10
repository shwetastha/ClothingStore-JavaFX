import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("inventory.fxml"));

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Clothing Store Inventory Management");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //you can download the glyph browser - link provided.
    public static void main(String[] args) {
        launch(args);
    }
}