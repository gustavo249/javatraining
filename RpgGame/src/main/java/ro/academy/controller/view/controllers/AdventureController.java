package ro.academy.controller.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ro.academy.controller.battle.Mission;
import ro.academy.model.heroes.Hero;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 12/05/2016.
 */
public class AdventureController extends HomeController implements Initializable{

    private Hero hero;
    protected Mission mission = new Mission();

    @FXML
    private Label storyLine = new Label();

    @FXML
    private Label heroName = new Label();

    @FXML
    private Label heroClass = new Label();

    @FXML
    private Label level = new Label();

    @FXML
    private Label xp = new Label();

    @FXML
    private Label dangerLabel = new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hero = heroDAO.getHero();
        mission.setHero(hero);

        storyLine.setText(mission.setStoryline());
        dangerLabel.setText(mission.danger());

        heroName.setText(hero.getName());
        heroClass.setText(hero.getRace().toString());
        level.setText("Level = " + hero.getLevel());

        xp.setText(hero.getActualXp() + " / " + hero.getLevelXp() + " needed");
    }


    @FXML
    public void danger() {
        Stage dangerStage = new Stage();
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/danger.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        dangerStage.setScene(new Scene(root, 375, 175));
        dangerStage.show();
        dangerStage.centerOnScreen();
    }

    @FXML
    Button closeButton;

    @FXML
    public void fight() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        changeScene("/battle.fxml");
    }



    @FXML
    public void run() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        backToMenuScreen();
    }

    @Override
    public void backToMenuScreen() {
        super.backToMenuScreen();
    }

    public Mission getMission() {
        return mission;
    }
}
