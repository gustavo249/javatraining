package ro.academy.controller.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.academy.controller.system.HeroDAO;
import ro.academy.model.base.History;
import ro.academy.model.heroes.Hero;

import java.io.IOException;

/**
 * Created by Gustavo on 10/05/2016.
 */
public class HomeController {

    protected static Stage stage;
    protected static HeroDAO heroDAO = new HeroDAO();

    public static void setStage(Stage stage) {
        HomeController.stage = stage;
        stage.setResizable(false);
    }


    @FXML
    public void createNewHero() {
        changeScene("/createHero.fxml");
    }

    @FXML
    public void loadGame() {
        Hero hero = History.readHero();
        heroDAO.setHero(hero);
        if (hero != null) {
            changeScene("/menu.fxml");
        }
    }

    @FXML
    public void exit() {
        System.exit(-1);
    }

    public void changeScene(String scenePath) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(scenePath));
            stage.setScene(new Scene(root, 590, 390));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToMainScreen() {
        changeScene("/welcomeScreen.fxml");
    }

    public void backToMenuScreen() {
        changeScene("/menu.fxml");
    }
}
