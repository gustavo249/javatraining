package ro.academy.controller.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import ro.academy.controller.battle.Mission;
import ro.academy.model.base.History;
import ro.academy.model.heroes.Hero;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 10/05/2016.
 */
public class MenuController extends HomeController implements Initializable{

    private Hero hero;

    @FXML
    private TextArea heroDetails = new TextArea();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hero = heroDAO.getHero();
        heroDetails.setText(hero.toString());
    }

    @FXML
    public void beginAdventure() {
        try {
            Mission.beginAdventure(hero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void saveGame() {
        Hero hero = heroDAO.getHero();
        History.saveHero(hero);
    }


    @FXML
    public void seeYourHero() {
        changeScene("/ro/academy/view/seeYourHero.fxml");
    }

    @Override
    public void backToMainScreen() {
        super.backToMainScreen();
    }

    public void backToMenuScreen() {
        changeScene("/ro/academy/view/menu.fxml");
    }


}
