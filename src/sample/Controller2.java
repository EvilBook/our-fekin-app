package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller2 implements Initializable {
    @FXML
    TextArea display;
    @FXML
    Button one;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        one.setOnMouseClicked(event -> {
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root = loader.load();


                Scene scene = new Scene(root);
                stage.setScene(scene);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        try{
            Path path= Paths.get("details.txt");

            List<String> lines = Files.readAllLines(path);

            for(String s:lines){
                File file=new File(s+".ser");

                try(ObjectInputStream ob= new ObjectInputStream(new FileInputStream(file))){
                    Item ii=(Item) ob.readObject();
                    display.appendText(ii.getName()+" "+ii.getQuantity()+"\n");



                }catch (FileNotFoundException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("WRONG!");
                    alert.setHeaderText("EVERYTHING IS WRONG!");
                    alert.setContentText("Just...just leave.");

                    alert.showAndWait();
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }catch(IOException e){
            e.printStackTrace();

        }






    }
}
