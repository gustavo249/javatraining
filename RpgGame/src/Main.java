import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.academy.controller.view.controllers.HomeController;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Main extends Application{
    public static Stage myStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ro\\academy\\view\\welcomeScreen.fxml"));
        primaryStage.setTitle("Spartacus");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        myStage = primaryStage;
        HomeController.setStage(myStage);
    }
}
