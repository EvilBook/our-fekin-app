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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller1 implements Initializable {
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





    }

    public void setData(MyArrayList<Item> liii) {
        try {
            for (int i = 0; i < liii.length(); i++) {
                display.appendText(liii.get(i).getName() + " " + liii.get(i).getQuantity() + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WRONG!");
            alert.setHeaderText("Make sure you know what you doing!");
            alert.setContentText("Add some shit first!");

            alert.show();
        }
    }
}
