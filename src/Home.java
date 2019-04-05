import java.io.*;
import java.util.HashMap;

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
        controller.setProductsMap(readProductsInventory());
        primaryStage.show();

        primaryStage.setOnCloseRequest(this::onClose);
    }

    private HashMap<Integer, Product> readProductsInventory(){
        BufferedReader fi =null;
        HashMap<Integer, Product> productsMap = new HashMap<>();

        try{
            fi = new BufferedReader(new FileReader(new File(Consts.FILENAME)));
            String line = fi.readLine();
            while (line!=null)
            {
                LogUtil.printLog(line);
                String[] lineArray = line.split(Consts.DELIM);
                if(lineArray[4].equalsIgnoreCase(Consts.CLOTHING)){
                    Clothing clothing=new Clothing(lineArray);
                    productsMap.put(clothing.getProductCode(), clothing);
                }else if (lineArray[4].equalsIgnoreCase(Consts.ACCESSORIES)){
                    Accessories accessories=new Accessories(lineArray);
                    productsMap.put(accessories.getProductCode(), accessories);
                }
                line = fi.readLine();
            }// end while loop
            fi.close();
        }catch(Exception e){
            LogUtil.printError("Exception While Reading: "+e.toString());
            if(fi!=null){
                try{
                    fi.close();
                }catch(Exception e2){
                    LogUtil.printError("Exception While Reading: "+e.toString());
                }
            }
        }
        return productsMap;

    }

    private void onClose(WindowEvent event) {
        BufferedWriter fo = null;

        try {
            fo = new BufferedWriter(new FileWriter(Consts.FILENAME));
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