package flores.javafx.recap.sessions;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class Screen2Controller {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button pButton;
    @FXML
    private Button bTaskButton;
    @FXML
    private TextArea outPutTxtArea;


    public void startTheBar(){
        System.out.println(" The Bar is started!");
        Service service = new Service() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        for(int i=0; i<100; i++){
                            updateProgress(i, 100);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                };
            }
        };

        progressBar.progressProperty().bind(service.progressProperty());
        service.start();
    }




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
