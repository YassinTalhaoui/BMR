/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.controller;

import g54892.bmr.model.Facade;
import g54892.bmr.view.UtilMethods;
import g54892.bmr.view.Datas;
import g54892.bmr.view.GraphicView1;
import g54892.bmr.view.GraphicView2;
import g54892.bmr.view.GraphicView3;
import g54892.bmr.view.Results;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Controller of the application that controllers the model and the differents
 * views.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Controller {

    private final Facade facade = new Facade();
    private final Datas data = new Datas();
    private final Results result = new Results(this.facade, this.data);
    private final GraphicView1 v1 = new GraphicView1(new NumberAxis(), new NumberAxis(), this.facade, this.data);
    private final GraphicView2 v2 = new GraphicView2(new NumberAxis(), new NumberAxis(), this.facade, this.data);
    private final GraphicView3 v3 = new GraphicView3(new NumberAxis(), new NumberAxis(), this.facade, this.data);

    /**
     * Initialises the application.
     *
     * @param root of all the fx components of the application.
     */
    public void initialise(VBox root) {
        HBox mainBox = new HBox();
        VBox leftSide = new VBox();
        TabPane tabPane = new TabPane();
        HBox graphicSide = new HBox(tabPane);
        HBox dataSide = new HBox();
        VBox buttons = new VBox();

        //the menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuFile.setStyle("-fx-font-size : 13pt;");
        menuBar.getMenus().add(menuFile);
        menuBar.setMinHeight(30);
        root.getChildren().add(menuBar);

        MenuItem exit = new MenuItem("Exit");
        menuFile.getItems().add(exit);
        exit.setOnAction((ActionEvent t) -> {
            System.exit(0);
        });

        root.getChildren().add(mainBox);
        root.setAlignment(Pos.TOP_CENTER);

        // --- Main Container after Root
        mainBox.getChildren().addAll(leftSide, graphicSide);
        mainBox.setAlignment(Pos.CENTER);

        //the calculation button
        Button calculator = UtilMethods.createButton("Calcul du BMR");

        root.setOnMouseMoved((event) -> {
            if (this.data.valid(calculator)) {
                calculator.setDisable(false);
            }
        });

        Tab tab1 = new Tab("Indice BMR Vs Poids (kg)", this.v1);
        Tab tab2 = new Tab("Poids (kg) vs Calories", this.v2);
        Tab tab3 = new Tab("Taille (cm) Vs Indice BMR", this.v3);
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        //The input datas
        calculator.setOnMouseClicked((MouseEvent arg0) -> {
            this.facade.setData(this.data.getTall(), this.data.getWeight(),
                    this.data.getAge(), this.data.getChoiceBox().getValue());
        });

        calculator.setOnMouseEntered((MouseEvent arg0) -> {
            this.data.displayErrorMessage();
        });

        //the clear button
        Button clear = UtilMethods.createButton("Effacer");
        clear.setOnMouseClicked((MouseEvent arg0) -> {
            UtilMethods.clearAllFields(this.data, this.result);
        });

        buttons.getChildren().addAll(calculator, clear);
        leftSide.getChildren().addAll(dataSide, buttons);
        leftSide.setAlignment(Pos.TOP_LEFT);

        dataSide.getChildren().addAll(data, result);
        dataSide.setAlignment(Pos.TOP_LEFT);

        graphicSide.setAlignment(Pos.TOP_RIGHT);
    }
}
