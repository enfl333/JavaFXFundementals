package flores.javafx.recap.sessions;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;


public class MainController implements Initializable {


    @FXML
    private BorderPane mainPane;

    public void changeToScreen1() throws IOException {
        System.out.println("changeToScreen1");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/screen1.fxml"));
        Parent root = loader.load();
        mainPane.setCenter(root);
    }

    public void changeToScreen2() throws IOException {
        System.out.println("changeToScreen2");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/screen2.fxml"));
        Parent root = loader.load();
        mainPane.setCenter(root);
    }

    public void changeToScreen3() throws IOException {
        System.out.println("changeToScreen3");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/screen3.fxml"));
        Parent root = loader.load();
        mainPane.setCenter(root);
    }

    public void setDefault()throws IOException {
        System.out.println("Default");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/default.fxml"));
        Parent root = loader.load();
        mainPane.setCenter(root);
    }


    public void menuActionHelp(){
        Alert aboutDialog = new Alert(Alert.AlertType.INFORMATION, "Re-cap JavaFx lessons");
        aboutDialog.show();
    }

    public void menuClose(){
        Alert closeDialog = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to close?");
        closeDialog.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Stage stage = (Stage) mainPane.getScene().getWindow();
                stage.close();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Locale.setDefault(Locale.ENGLISH);
            setDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
