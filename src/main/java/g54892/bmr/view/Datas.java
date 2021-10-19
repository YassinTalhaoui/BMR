/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.view;

import g54892.bmr.model.LifeStyle;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * This class represents all the outputs/resutls contained in one GridePane
 * element of the scene.
 *
 * @author Talhaoui Yassin - G54892
 */
public final class Datas extends GridPane {

    private final HBox groups;
    private final Label lblTitle = UtilMethods.createSubtitle("Données");
    private final Label tall = UtilMethods.createLabel("Taille (cm)");
    private final TextField tallField;
    private final Label weight = UtilMethods.createLabel("Poids (kg)");
    private final TextField weightField;
    private final Label age = UtilMethods.createLabel("Age (années)");
    private final TextField ageField;
    private final Label sexe = UtilMethods.createLabel("Sexe");
    private final ToggleGroup group;
    private final RadioButton button1;
    private final RadioButton button2;
    private final Label style = UtilMethods.createLabel("Style de vie");
    private final ChoiceBox<LifeStyle> choiceBox = new ChoiceBox(FXCollections
            .observableArrayList(LifeStyle.values()));

    /**
     * Constructor of Datas
     */
    public Datas() {
        this.setPadding(new Insets(10));
        this.setHgap(6);
        this.setVgap(6);

        // RadioButton1 : Male
        this.button1 = UtilMethods.createRadioButton("Homme");
        this.button1.setSelected(true);

        // RadioButton2 : Female
        this.button2 = UtilMethods.createRadioButton("Femme");
        this.group = new ToggleGroup();
        this.button1.setToggleGroup(this.group);
        this.button2.setToggleGroup(this.group);
        this.groups = new HBox(10);
        this.groups.getChildren().addAll(this.button1, this.button2);

        this.choiceBox.setValue(LifeStyle.ACTIF);
        this.choiceBox.setPrefWidth(200);
        this.choiceBox.setStyle("-fx-font-size : 13pt;");

        this.tallField = UtilMethods.createIntTextField("Taille en cm");
        this.weightField = UtilMethods.createIntTextField("Poids en kg");
        this.ageField = UtilMethods.createIntTextField("Age en années");

        this.add(this.lblTitle, 0, 0);
        this.add(this.tall, 0, 1);
        this.add(this.tallField, 1, 1);
        this.add(this.weight, 0, 2);
        this.add(this.weightField, 1, 2);
        this.add(this.age, 0, 3);
        this.add(this.ageField, 1, 3);
        this.add(this.sexe, 0, 4);
        this.add(this.groups, 1, 4);
        this.add(this.style, 0, 5);
        this.add(this.choiceBox, 1, 5);
    }

    /**
     * Simple getter of group.
     *
     * @return group.
     */
    public ToggleGroup getGroup() {
        return this.group;
    }

    /**
     * Simple getter of groups.
     *
     * @return groups.
     */
    public HBox getGroups() {
        return this.groups;
    }

    /**
     * Simple getter of button1.
     *
     * @return button1.
     */
    public RadioButton getButton1() {
        return this.button1;
    }

    /**
     * Simple getter of button2.
     *
     * @return button2.
     */
    public RadioButton getButton2() {
        return this.button2;
    }

    /**
     * Simple getter of choiceBox.
     *
     * @return choiceBox.
     */
    public ChoiceBox<LifeStyle> getChoiceBox() {
        return this.choiceBox;
    }

    /**
     * Simple getter of tallField.
     *
     * @return tallField.
     */
    public TextField getTallField() {
        return this.tallField;
    }

    /**
     * Simple getter of weightField.
     *
     * @return weightField.
     */
    public TextField getWeightField() {
        return this.weightField;
    }

    /**
     * Simple getter of ageField.
     *
     * @return ageField.
     */
    public TextField getAgeField() {
        return this.ageField;
    }

    /**
     * Parses the input value of the tall into a double value and retuns it.
     *
     * @return the tall.
     */
    public double getTall() {
        return Double.parseDouble(this.tallField.getText());
    }

    /**
     * Parses the input value of the weight into a double value and retuns it.
     *
     * @return the weight.
     */
    public double getWeight() {
        return Double.parseDouble(this.weightField.getText());
    }

    /**
     * Parses the input value of the age into a double value and retuns it.
     *
     * @return the age.
     */
    public double getAge() {
        return Double.parseDouble(this.ageField.getText());
    }

    /**
     * Checks that all the fields to be filled in are well filled in.
     *
     * @param btn Button a given button.
     * @return true if no field is empty, false otherwise.
     */
    public boolean valid(Button btn) {
        btn.setDisable(true);
        return !(this.getTallField().getText().isEmpty()
                || this.getWeightField().getText().isEmpty()
                || this.getAgeField().getText().isEmpty()
                || (!this.getButton1().isSelected()
                && !this.getButton2().isSelected())
                || this.getChoiceBox().getValue() == null);
    }

    /**
     * This method is executed if the user tries to enter 0 in one of the data
     * fields.
     */
    public void displayErrorMessage() {
        if ((this.getTallField().getText().equals("0"))
                || (this.getWeightField().getText().equals("0"))
                || (this.getAgeField().getText().equals("0"))) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur d'encodage");
            alert.setContentText("Vous devez entrez une valeur "
                    + "strictement supérieure à zéro.");

            if (this.getTallField().getText().equals("0")) {
                alert.setHeaderText("Valeur de la taille erronée");
            } else if (this.getWeightField().getText().equals("0")) {
                alert.setHeaderText("Valeur du poids erronée");
            } else if (this.getAgeField().getText().equals("0")) {
                alert.setHeaderText("Valeur de l'âge erronée");
            }
            alert.showAndWait();
        }
    }
}
