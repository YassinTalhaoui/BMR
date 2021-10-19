/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.view;

import g54892.bmr.model.Facade;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;

/**
 * This class is a graphical representation of the calorie requirements
 * according to weight.
 *
 * @author Talhaoui Yassin - G54892
 */
public class GraphicView2 extends GraphicViews {

    /**
     * Constructor of GraphicView2.
     *
     * @param xAxis the horizontal axe of the graphic.
     * @param yAxis the vertical axe of the graphic.
     * @param f a given instance of Facade.
     * @param d a given instance of Datas.
     */
    public GraphicView2(Axis<Number> xAxis, Axis<Number> yAxis, Facade f, Datas d) {
        super(xAxis, yAxis, f, d);
        this.setTitle("Poids en kg Vs Besoins en Calories");
        xAxis.setLabel("Calories");
        yAxis.setLabel("Poids (kg)");
    }

    /**
     * Calculates the calorie requirements graphically according to the weight.
     */
    @Override
    void updateState() {
        if (super.data.getButton1().isSelected()) {
            super.men.getData().add((new XYChart.Data(Double.
                    parseDouble(super.data.getWeightField().getText()),
                    super.facade.calculateMaleCalories())));
        } else {
            super.women.getData().add((new XYChart.Data(Double.
                    parseDouble(super.data.getWeightField().getText()),
                    super.facade.calculateFemaleCalories())));
        }
    }
}
