/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.view;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * This utility class contains contains a whole series of useful methods which
 * are necessary for the development of the graphical interface.
 *
 * @author Talhaoui Yassin - G54892
 */
public class UtilMethods {

    /**
     * Creates a customised text field with a given prompt text that allows just
     * the encoding of digits.
     *
     * @param promptText the prompt text to display in the text field.
     * @return the text field.
     */
    public static TextField createIntTextField(String promptText) {
        TextField tfdInteger = new TextField();
        tfdInteger.setPromptText(promptText);
        tfdInteger.setPrefColumnCount(11);
        tfdInteger.setFont(Font.font("System", 17));
        tfdInteger.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (!this.isValid(event.getCharacter())
                        || tfdInteger.getPromptText()
                                .equalsIgnoreCase("Résultat du BMR")
                        || tfdInteger.getPromptText()
                                .equalsIgnoreCase("Dépenses en calories")) {
                    event.consume();
                }
            }

            /**
             * Private method that checks that the given text contains a digit.
             *
             * @param text a given text, String.
             * @return true if the given String contains a digit, false
             * otherwise.
             */
            private boolean isValid(String text) {
                boolean isValid = true;
                try {
                    Integer.parseInt(text);
                } catch (NumberFormatException numberFormatException) {
                    isValid = false;
                }
                return isValid;
            }
        });
        return tfdInteger;
    }

    /**
     * Creates an object Label and returns it.
     *
     * @param text the text to display.
     * @return the label.
     */
    public static Label createLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("System", FontWeight.BOLD, 17));
        return label;
    }

    /**
     * Creates customized titles with a Label object and retruns it.
     *
     * @param text the text to display.
     * @return the title, Label.
     */
    public static Label createSubtitle(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("System", FontWeight.BOLD, 20));
        label.setUnderline(true);
        return label;
    }

    /**
     * Creates a radio button, configures, sets it in the given ToggleGroup and
     * returns it.
     *
     * @param text the text associated to the creates radio button.
     * @return the radio button.
     */
    public static RadioButton createRadioButton(String text) {
        ToggleGroup group = new ToggleGroup();
        RadioButton rb = new RadioButton(text);
        rb.setFont(Font.font("System", FontWeight.BOLD, 17));
        rb.setToggleGroup(group);
        return rb;
    }

    /**
     * Creates a button in which the given text is set as a parameter and
     * returns this button.
     *
     * @param text String, the text to set into the button.
     * @return the button.
     */
    public static Button createButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("System", FontWeight.BOLD, 15));
        btn.setMinWidth(635);
        btn.setMinHeight(50);
        return btn;
    }

    /**
     * Clears all fields from the BMR calculation screen.
     *
     * @param data a given instance of Datas.
     * @param result a given instance of Results.
     */
    public static void clearAllFields(Datas data, Results result) {
        data.getTallField().clear();
        data.getWeightField().clear();
        data.getAgeField().clear();
        result.getBmrField().clear();
        result.getCaloriesField().clear();
        data.getButton1().setSelected(false);
        data.getButton2().setSelected(false);
        data.getChoiceBox().setValue(null);
    }
}
