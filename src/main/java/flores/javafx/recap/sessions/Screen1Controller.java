package flores.javafx.recap.sessions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import org.apache.log4j.Logger;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Screen1Controller implements Initializable {
    @FXML
    private TextField enterNameTxTField;
    @FXML
    private Button enterNameButton;
    @FXML
    private ListView<String> nameList;

    public void addName(){
        String name = enterNameTxTField.getText().trim();
        if(name.trim().length()>0){
            System.out.println("Getting text from the field for a Name!!!:"+name);
            Logger.getLogger(this.getClass()).debug(" ProcesName: "+name);
            enterNameTxTField.clear();
            nameList.getItems().add(name);
            enterNameTxTField.requestFocus();

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Can't enter an empty name");
            alert.show();
        }

    }

    public void deleteName(){
        int deleteIndex =  nameList.getSelectionModel().getSelectedIndex();
        Logger.getLogger(this.getClass()).debug("Selected Index to delete: "+deleteIndex);
        if(deleteIndex == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select an item from the list.");
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to format your system?");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    nameList.getItems().remove(deleteIndex);
                    nameList.refresh();
                    nameList.getSelectionModel().clearSelection();

                }
            });
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<String> names = FXCollections.observableArrayList("Default Name");
        Locale.setDefault(Locale.ENGLISH);
        nameList.setItems(names);
        enterNameTxTField.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER)
            {
                addName();
            }
        });

    }
}
