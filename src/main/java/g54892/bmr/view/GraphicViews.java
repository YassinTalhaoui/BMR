/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.view;

import g54892.bmr.model.Facade;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * Abstract class that is implemented by the differents graphic representations
 * of the bmr calculator.
 *
 * @author Talhoaui Yassin - G54892
 */
public abstract class GraphicViews extends LineChart<Number, Number> implements Observer {

    protected final XYChart.Series men = new XYChart.Series();
    protected final XYChart.Series women = new XYChart.Series();
    protected final Datas data;
    protected final Facade facade;

    /**
     * Constructor of GraphicViews.
     *
     * @param xAxis the horizontal axe of the graphic.
     * @param yAxis the vertical axe of the graphic.
     * @param f a given instance of Facade.
     * @param d a given instance of Datas.
     */
    public GraphicViews(Axis<Number> xAxis, Axis<Number> yAxis, Facade f, Datas d) {
        super(xAxis, yAxis);
        this.facade = f;
        this.data = d;

        this.men.setName("Données Hommes");
        this.women.setName("Données Femmes");

        this.getData().add(this.men);
        this.getData().add(this.women);

        this.facade.addObserver(this);
    }

    /**
     * Updates the state of a chart.
     */
    abstract void updateState();

    /**
     * This method is called whenever the observed object is changed.
     *
     * @param o a given Observable.
     * @param arg a given Object.
     */
    @Override
    public void update(Observable o, Object arg) {
        this.updateState();
    }
}
