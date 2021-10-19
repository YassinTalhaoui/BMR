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
 * This class is a graphical representation of BMR according to weight.
 *
 * @author Talhaoui Yassin - G54892
 */
public class GraphicView1 extends GraphicViews {

    /**
     * Constructor of GraphicView1.
     *
     * @param xAxis the horizontal axe of the graphic.
     * @param yAxis the vertical axe of the graphic.
     * @param f a given instance of Facade.
     * @param d a given instance of Datas.
     */
    public GraphicView1(Axis<Number> xAxis, Axis<Number> yAxis, Facade f, Datas d) {
        super(xAxis, yAxis, f, d);
        this.setTitle("Indice BMR Vs Poids en kg");
        xAxis.setLabel("Poids (kg)");
        yAxis.setLabel("BMR");
    }

    /**
     * Calculates the bmr graphically according to the weight.
     */
    @Override
    void updateState() {
        if (super.data.getButton1().isSelected()) {
            super.men.getData().add((new XYChart.Data(Double.
                    parseDouble(super.data.getWeightField().getText()),
                    super.facade.calculateMaleBMR())));
        } else {
            super.women.getData().add((new XYChart.Data(Double.
                    parseDouble(super.data.getWeightField().getText()),
                    super.facade.calculateFemaleBMR())));
        }
    }
}
