/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54892.bmr.model;

/**
 * Enumeration of all the lifestyles.
 *
 * @author Talhaoui Yassin - G54892
 */
public enum LifeStyle {
    SEDENTAIRE("Sédentaire", 1.2),
    PEU_ACTIF("Peu Actif", 1.375),
    ACTIF("Actif", 1.55),
    FORT_ACTIF("Fort Actif", 1.725),
    EXTREMEMENT_ACTIF("Extrêmement Actif", 1.9);
    private final String str;
    private final double factor;

    /**
     * Construcotr of LifeStyle.
     *
     * @param str a given String.
     * @param factor an Integer that represents the multiplicative factor
     * corresponding to a given lifestyle that will allow us to calculate the
     * calorie needs.
     */
    private LifeStyle(String str, double factor) {
        this.str = str;
        this.factor = factor;
    }

    /**
     * Simple getter of factor.
     *
     * @return factor, double.
     */
    public double getFactor() {
        return this.factor;
    }

    /**
     * This object (which is already a string!) is itself returned.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return this.str;
    }
}
