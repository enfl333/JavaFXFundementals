package flores.javafx.recap.sessions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen1Controller implements Initializable {
    @FXML
    private TextField enterNameTxTField;
    @FXML
    private Button enterNameButton;
    @FXML
    private ListView<String> nameList;

    public void processName(){
        String name = enterNameTxTField.getText().trim();
        System.out.println("Getting text from the field for a Name!!!:"+name);
        Logger.getLogger(this.getClass()).debug(" ProcesName: "+name);
        enterNameTxTField.clear();
        nameList.getItems().add(name);
    }

    public void deleteName(){
        int deleteIndex =  nameList.getSelectionModel().getSelectedIndex();
        Logger.getLogger(this.getClass()).debug("Selected Index to delete: "+deleteIndex);
        if(deleteIndex == -1){
            //Add Alert explaining need to select A name first
        }else{

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ObservableList<String> names = FXCollections.observableArrayList("Default Name");
        nameList.setItems(names);
    }
}
