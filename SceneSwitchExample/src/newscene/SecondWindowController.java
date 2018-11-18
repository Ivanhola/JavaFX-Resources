/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newscene;

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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sceneswitchexample.MainWindow;

/**
 * FXML Controller class
 *
 * @author Ivans
 */
public class SecondWindowController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private AnchorPane mainPane;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setBackground();
    }    

    @FXML
    private void backToFirstScene(ActionEvent event) {
     closeStage();
     loadWindow("/sceneswitchexample/MainWindowFXML.fxml","First Window");
    }
    
    private void closeStage() {
        ((Stage)backButton.getScene().getWindow()).close();
       
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
     
       private void setBackground(){
    Image background = new Image("resources/background2.jpg", 600, 400, false, true);
    BackgroundImage backgroundImg = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT, null);
    mainPane.setBackground(new Background(backgroundImg));
}
    
}
