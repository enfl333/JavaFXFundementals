package flores.javafx.recap.sessions;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Screen1Controller {
    @FXML
    private TextField enterNameTxTField;
    @FXML
    private Button enterNameButton;

    public void processName(){
        String name = enterNameTxTField.getText().trim();
        System.out.println("Getting text from the field for a Name:"+name);
        enterNameTxTField.clear();
    }



}
