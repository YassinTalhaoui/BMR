/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.view;

import g54892.bmr.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This class represents all the input datas contained in the GridePane element
 * of the scene.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Results extends GridPane implements Observer {

    private final Datas data;
    private final Facade facade;
    private final TextField bmrField;
    private final TextField caloriesField;
    private final Label calories = UtilMethods.createLabel("Calories");
    private final Label res = UtilMethods.createSubtitle("Résultats");
    private final Label BMR = UtilMethods.createLabel("BMR");

    /**
     * Constructor of Results.
     *
     * @param f a given instance of Facade.
     * @param d a given instance of Datas.
     */
    public Results(Facade f, Datas d) {
        this.facade = f;
        this.data = d;

        this.setPadding(new Insets(10));
        this.setHgap(6);
        this.setVgap(6);

        this.bmrField = UtilMethods.createIntTextField("Résultat du BMR");
        this.caloriesField = UtilMethods.createIntTextField("Dépenses en calories");

        this.bmrField.setEditable(false);
        this.caloriesField.setEditable(false);

        this.add(this.res, 0, 0);
        this.add(this.BMR, 0, 1);
        this.add(this.bmrField, 1, 1);
        this.add(this.calories, 0, 2);
        this.add(this.caloriesField, 1, 2);

        this.facade.addObserver(this);
    }

    /**
     * Simple getter of bmrField.
     *
     * @return bmrField.
     */
    public TextField getBmrField() {
        return this.bmrField;
    }

    /**
     * Simple getter of caloriesField.
     *
     * @return caloriesField.
     */
    public TextField getCaloriesField() {
        return this.caloriesField;
    }

    /**
     * Sets the given text in the bmrField element.
     *
     * @param text a given String.
     */
    public void setBmr(String text) {
        this.bmrField.setStyle("-fx-text-fill : black;");
        this.bmrField.setText(text);
    }

    /**
     * Sets the given in text in the caloriesField element.
     *
     * @param text a given String.
     */
    public void setCalorie(String text) {
        this.caloriesField.setStyle("-fx-text-fill : black;");
        this.caloriesField.setText(text);
    }

    /**
     * Private method that places the corresponding results in the corresponding
     * textField.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (this.data.getButton1().isSelected()) {
            this.setBmr(String.valueOf(this.facade.calculateMaleBMR()));
            this.setCalorie(String.valueOf(this.facade.calculateMaleCalories()));
        } else {
            this.setBmr(String.valueOf(this.facade.calculateFemaleBMR()));
            this.setCalorie(String.valueOf(this.facade.calculateFemaleCalories()));
        }
    }
}
