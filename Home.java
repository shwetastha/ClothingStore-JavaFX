import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Home extends Application {
    Controller controller;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inventory.fxml"));
        
        
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root, 600, 400);
        

        primaryStage.setTitle("Clothing Store Inventory Management");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        primaryStage.setOnCloseRequest(this::onClose);
    }

    private void onClose(WindowEvent event) {
        BufferedWriter fo = null;

        try {
            fo = new BufferedWriter(new FileWriter("productsInventory.csv", true));
            for (Integer i : controller.getProductsMap().keySet()) {
                fo.append(controller.getProductsMap().get(i).toCSV());
            }
            
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.printError("Exception occured.");
            LogUtil.printError(e.toString());
            if (fo!=null){
                try{
                    fo.close();
                }catch(Exception e2){
                    LogUtil.printError("Exception occured while cloing the bufferedwriter.");
                }
            }
        } 
    }
    //you can download the glyph browser - link provided.
    public static void main(String[] args) {
        launch(args);
    }
}