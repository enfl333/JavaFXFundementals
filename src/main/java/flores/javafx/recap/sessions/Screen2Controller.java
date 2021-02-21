package flores.javafx.recap.sessions;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

public class Screen2Controller {

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Button pButton;

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
}
