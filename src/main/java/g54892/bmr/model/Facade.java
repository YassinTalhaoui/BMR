/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.model;

import java.util.Observable;

/**
 * Facade of the application that will retain the input data to calculate and
 * output the results.
 *
 * @author Talhaoui Yassin - G54892
 */
public class Facade extends Observable {

    private final User user;

    /**
     * Constructor of Facade.
     */
    public Facade() {
        this.user = new User(0, 0, 0, LifeStyle.SEDENTAIRE);
    }

    /**
     * Set to the user, the given informations : tall, weight, age and life
     * style.
     *
     * @param tall double, the tall of the user.
     * @param weight double, the weight of the user.
     * @param age double, the age of the user.
     * @param lifeStyle LifeStyle, the life style of the user.
     */
    public void setData(double tall, double weight, double age, LifeStyle lifeStyle) {
        this.user.setTall(tall);
        this.user.setWeight(weight);
        this.user.setAge(age);
        this.user.setLifeStyle(lifeStyle);
        super.setChanged();
        super.notifyObservers();
    }

    /**
     * Calculates the value of the bmr for a man with the coefficients
     * corresponding to men.
     *
     * @return the bmr for the men.
     */
    public double calculateMaleBMR() {
        return (((13.7 * this.user.getWeight())) + (5 * this.user.getTall()))
                - ((6.8 * this.user.getAge())) + 66;
    }

    /**
     * Multiplies the BMR by a factor dependent on the level of activity to
     * calculate the daily calorie requirements of a male individual.
     *
     * @return the daily calorie requirements.
     */
    public double calculateMaleCalories() {
        return this.calculateMaleBMR() * this.user.getLifeStyle().getFactor();
    }

    /**
     * Calculates the value of the bmr for a man with the coefficients
     * corresponding to a woaman.
     *
     * @return the bmr for a woman.
     */
    public double calculateFemaleBMR() {
        return (((9.6 * this.user.getWeight()) + (1.8 * this.user.getTall()))
                - ((4.7 * this.user.getAge()))) + 655;
    }

    /**
     * Multiplies the BMR by a factor dependent on the level of activity to
     * calculate the daily calorie requirements of a woman.
     *
     * @return the daily calorie requirements.
     */
    public double calculateFemaleCalories() {
        return this.calculateFemaleBMR() * this.user.getLifeStyle().getFactor();
    }
}
