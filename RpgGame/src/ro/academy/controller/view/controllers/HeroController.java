package ro.academy.controller.view.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ro.academy.model.heroes.Hero;
import ro.academy.model.heroes.Ninja;
import ro.academy.model.heroes.Shaman;
import ro.academy.model.heroes.Warrior;
import ro.academy.model.races.HeroRaces;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 10/05/2016.
 */
public class HeroController extends HomeController implements Initializable {

    private ObservableList<HeroRaces> heroRaces =
            FXCollections.observableArrayList(HeroRaces.WARRIOR, HeroRaces.NINJA, HeroRaces.SAMAN);
    @FXML
    private ChoiceBox<HeroRaces> heroClass;
    @FXML
    private TextField heroName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        heroClass.setValue(HeroRaces.WARRIOR);
        heroClass.setItems(heroRaces);
    }

    @FXML
    public void submitNewHero() {
        Hero hero;
        String name = heroName.getText();
        if (heroClass.getValue().equals(HeroRaces.WARRIOR)) {
            hero = new Warrior(name);
        } else if (heroClass.getValue().equals(HeroRaces.NINJA)) {
            hero = new Ninja(name);
        } else {
            hero = new Shaman(name);
        }
        System.out.println(hero);

        heroDAO.setHero(hero);
        changeScene("/ro/academy/view/menu.fxml");
    }

    @Override
    public void backToMainScreen() {
        super.backToMainScreen();
    }
}
