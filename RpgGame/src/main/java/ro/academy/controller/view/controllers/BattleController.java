package ro.academy.controller.view.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ro.academy.model.heroes.Hero;
import ro.academy.model.monsters.Monster;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gustavo on 12/05/2016.
 */
public class BattleController extends AdventureController implements Initializable{

    private Hero hero;
    private Monster monster;

    @FXML
    private TextArea battleReport = new TextArea();
    @FXML
    private Label battleOutcome = new Label();

    @FXML
    private Label heroName = new Label();
    @FXML
    private Label heroLevel = new Label();
    @FXML
    private Label heroHp = new Label();
    @FXML
    private Label heroStrength = new Label();
    @FXML
    private Label heroDefence = new Label();
    @FXML
    private Label monsterName = new Label();
    @FXML
    private Label monsterLevel = new Label();
    @FXML
    private Label monsterHp = new Label();
    @FXML
    private Label monsterStrength = new Label();
    @FXML
    private Label monsterDefence = new Label();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        hero = heroDAO.getHero();
        mission.danger();
        monster = mission.getMonster();

        heroName.setText(hero.getName());
        monsterName.setText(monster.getRace().toString());

        heroLevel.setText(String.valueOf(hero.getLevel()));
        monsterLevel.setText(String.valueOf(monster.getLevel()));

        heroHp.setText(String.valueOf(hero.getHitPoints()));
        monsterHp.setText(String.valueOf(monster.getHitPoints()));

        heroStrength.setText(String.valueOf(hero.getStrength()));
        monsterStrength.setText(String.valueOf(monster.getStrength()));

        heroDefence.setText(String.valueOf(hero.getDefense()));
        monsterDefence.setText(String.valueOf(monster.getDefense()));

        mission.setHero(hero);
        mission.startBattle();

        battleReport.setText(mission.getBattle().getBattleReport().toString());
        battleOutcome.setText(mission.getBattle().getBattleOutcome().toString());

    }

    @FXML
    public void equiItem() {

    }

    @Override
    public void backToMenuScreen() {
        super.backToMenuScreen();
    }
}
