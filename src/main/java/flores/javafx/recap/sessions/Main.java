package flores.javafx.recap.sessions;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
/**
 * Adding comments.
 * @Author enfl
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Refresh JavaFx");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger log = Logger.getLogger(Main.class);
        log.info("This is Logger Info");
        launch(args);

    }
}
