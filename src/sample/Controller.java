package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class Controller implements Initializable {
    @FXML
    Button addItem;
    @FXML
    TextField nameTextField;
    @FXML
    TextField quantity;
    @FXML
    Button two;
    @FXML
    Button three;


    Pattern pattern=Pattern.compile("^[a-zA-z]+$");
    Pattern pattern1= Pattern.compile("^[0-9]+$");
    String name;
    String q;
    String files;
    MyArrayList<Item> liii=new MyArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Object i: liii.objectArray){
            System.out.println(i);

        }
        System.out.println(liii.length());
        addItem.setOnMouseClicked(event -> {
            name=nameTextField.getText();
            q=quantity.getText();
            Save();
        });
        two.setOnMouseClicked(event -> {
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("sample1.fxml"));
                Parent root = loader.load();


                Controller1 agc= loader.<Controller1>getController();
                agc.setData(liii);
                Scene scene = new Scene(root);
                stage.setScene(scene);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        three.setOnMouseClicked(event -> {
            try {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
                Parent root = loader.load();


                Scene scene = new Scene(root);
                stage.setScene(scene);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

    }
    public void Save(){
        ArrayList<String> details=new ArrayList<>();
        Path path= Paths.get("details.txt");
        try {

        if(pattern.matcher(nameTextField.getText()).matches() && pattern1.matcher(quantity.getText()).matches()){

            files=nameTextField.getText();
            details.add(files);
            Files.write(path,details, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Item newItem=new Item(name,Integer.parseInt(q));
            liii.add(newItem);

            File file1 = new File(nameTextField.getText()+".ser");
            try(ObjectOutputStream oOut= new ObjectOutputStream(new FileOutputStream(file1))){
                oOut.writeObject(newItem);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Object i: liii.objectArray){
                System.out.println(i);

            }
            System.out.println(liii.length());

        }else if(!pattern1.matcher(quantity.getText()).matches() && pattern.matcher(nameTextField.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WRONG!");
            alert.setHeaderText("Make sure you know what you doing!");
            alert.setContentText("Write a number bitch.");

            alert.showAndWait();

        }else if(!pattern.matcher(nameTextField.getText()).matches() && pattern1.matcher(quantity.getText()).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WRONG!");
            alert.setHeaderText("Make sure you know what you doing!");
            alert.setContentText("ONLY LETTERS Ho! cmon...");

            alert.showAndWait();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("WRONG!");
            alert.setHeaderText("EVERYTHING IS WRONG!");
            alert.setContentText("Just...just leave.");

            alert.showAndWait();

        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
