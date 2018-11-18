/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sceneswitchexample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ivans
 */
public class MainWindow implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button button;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //closes the current window
       closeStage();
       //opens a new window/FXML File
       loadWindow("/newscene/SecondWindow.fxml", "Second Scene");
    }
    
     private void closeStage() {
        ((Stage)label.getScene().getWindow()).close();
       
    }
    
    //function used to load in a new window, will pass in a location, and a title
    private void loadWindow(String Location, String title){
         try {
              //standard operations for showing and opening a new window
              Parent parent = FXMLLoader.load(getClass().getResource(Location));
              Stage stage = new Stage(StageStyle.DECORATED);
              stage.setTitle(title);
              stage.setScene(new Scene(parent));
              stage.show();
              
              
              
          } catch (IOException ex) {
              Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setBackground();
    }    
    
    private void setBackground(){
    Image background = new Image("resources/background1.jpg", 320, 200, false, true);
    BackgroundImage backgroundImg = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
    mainPane.setBackground(new Background(backgroundImg));
}
    
}
