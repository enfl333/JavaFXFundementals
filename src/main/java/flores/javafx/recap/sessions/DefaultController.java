package flores.javafx.recap.sessions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class DefaultController implements Initializable {

    @FXML private TextArea defaultTxtArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            StringBuffer buff = readInfoFromFile();
            if(buff == null){
                defaultTxtArea.setText("");
            }else{
                defaultTxtArea.setText(buff.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private StringBuffer readInfoFromFile() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("recapInfo").getFile());
        StringBuffer buffer = null;
        boolean exists = file.exists();
        if(exists){
            buffer = new StringBuffer();
                Scanner myReader = new Scanner(file);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    buffer.append(data+"\n");
                }
                myReader.close();

        }
        return buffer;
    }


}
