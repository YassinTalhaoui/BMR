/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr;

import g54892.bmr.controller.Controller;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Application with a graphical interface, that calculates the BMR 
 * (Basal Metabolic Rate).
 *
 * @author Talhaoui Yassin - G54892
 */
public class Bmr extends Application {

    // Entry point of the application.
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the BMR calculation screen as a graphical user interface.
     *
     * @param stage a given stage.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Calcul du BMR");
        VBox root = new VBox();
        new Controller().initialise(root);
        Scene scene = new Scene(root, 1170, 440);
        stage.setScene(scene);
        stage.show();
    }
}
