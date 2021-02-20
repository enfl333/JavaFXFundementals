package flores.javafx.recap.sessions;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Screen3Controller {

    @FXML
    private Button bTaskButton;

    @FXML
    private TextArea outPutTxtArea;



    public void startBackgroundTask(){
        System.out.println("Running background task");

        Service<String> service = new Service<String>() {
            @Override
            protected Task<String> createTask() {
                Task<String> task = new Task<String>() {
                    @Override
                    protected String call() throws Exception {
                        for (int i = 0; i < 10; i++) {
                            outPutTxtArea.setText("The final upp count.."+i);
                            Thread.sleep(1000);
                        }
                        outPutTxtArea.clear();
                        return null;
                    }
                };

                return task;
            }
        };

        service.start();

    }
}
