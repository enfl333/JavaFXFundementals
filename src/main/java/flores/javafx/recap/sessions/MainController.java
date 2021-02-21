package flores.javafx.recap.sessions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {


    @FXML
    private BorderPane mainPane;



    public void changeToScreen1() throws IOException {
        System.out.println("changeToScreen1");
        Parent root = FXMLLoader.load(getClass().getResource("screen1.fxml"));
        mainPane.setCenter(root);
    }

    public void changeToScreen2() throws IOException {
        System.out.println("changeToScreen2");

        Parent root = FXMLLoader.load(getClass().getResource("screen2.fxml"));
        mainPane.setCenter(root);
    }

    public void changeToScreen3() throws IOException {
        System.out.println("changeToScreen3");
        Parent root = FXMLLoader.load(getClass().getResource("screen3.fxml"));
        mainPane.setCenter(root);
    }

    public void setDefault()throws IOException {
        System.out.println("Default");
        Parent root = FXMLLoader.load(getClass().getResource("default.fxml"));
        mainPane.setCenter(root);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
