/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.model;

/**
 * This class represents a user for which you want to calculate the bmr and
 * calorie requirements.
 *
 * @author Talhaoui Yassin - G54892
 */
public class User {

    private double tall;
    private double weight;
    private double age;
    private LifeStyle lifeStyle;

    /**
     * Constructor of User.
     *
     * @param tall double, the tall of the user.
     * @param weight double, the weight of the user.
     * @param age double, the age of the user.
     * @param lifeStyle LifeStyle, the life style of the user.
     */
    public User(double tall, double weight, double age, LifeStyle lifeStyle) {
        this.tall = tall;
        this.weight = weight;
        this.age = age;
        this.lifeStyle = lifeStyle;
    }

    /**
     * Simple getter of tall.
     *
     * @return the tall.
     */
    public double getTall() {
        return this.tall;
    }

    /**
     * Simple getter of weight.
     *
     * @return the weight.
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     * Simple getter of age.
     *
     * @return the age.
     */
    public double getAge() {
        return this.age;
    }

    /**
     * Simple getter of lifeStyle.
     *
     * @return the life style.
     */
    public LifeStyle getLifeStyle() {
        return this.lifeStyle;
    }

    /**
     * Simple setter of tall.
     *
     * @param tall of the user.
     */
    public void setTall(double tall) {
        this.tall = tall;
    }

    /**
     * Simple setter of weight.
     *
     * @param weight of the user.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Simple setter of age.
     *
     * @param age of the user.
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * Simple sette of lifeStyle.
     *
     * @param lifeStyle of the user.
     */
    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }
}
