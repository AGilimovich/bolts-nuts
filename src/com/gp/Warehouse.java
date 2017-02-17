package com.gp;

/**
 * Class represents the warehouse.
 */
public class Warehouse {

    private int nutsNumber;
    private int boltsNumber;

    private int nutsLostPercentage;
    private int boltsLostPercentage;

    private int nutsPrice;
    private int boltsPrice;

    /**
     * Method counts losses according to the warehouse data.
     * <p>Algorithm for counting losses:
     * <ul>
     * <li>counting nuts which were not lost;
     * <li>counting bolts which were not lost;
     * <li>finding minimum out of two values: not lost nuts and not lost bolts. Minimum value is equal to number of pairs which can be assembled with one bolt and one nut;
     * <li>nuts and bolts left without pair considered lost;
     * <li>losses is a number of lost bolts and nuts multiplied by their price.
     * </ul>
     *
     * @return amount of losses.
     */
    public int countLosses() {
        int nutsNotLost = nutsNumber * (100 - nutsLostPercentage) / 100;
        int boltsNotLost = boltsNumber * (100 - boltsLostPercentage) / 100;
        int fullPairQuantity = Math.min(nutsNotLost, boltsNotLost);
        return (nutsNumber - fullPairQuantity) * nutsPrice + (boltsNumber - fullPairQuantity) * boltsPrice;

    }

    /**
     * Sets information about nuts in the warehouse.
     *
     * @param nutsNumber         number of nuts were in warehouse before loss. Allowed values: from 100 to 30000, divisible by 100.
     * @param nutsLostPercentage percentage of nuts were lost.Allowed values: from 0 to 100.
     * @param nutsPrice          price of one nut. Allowed values: from 1 to 100.
     */
    public void setNutsData(int nutsNumber, int nutsLostPercentage, int nutsPrice) {
        if (nutsNumber < 100 || nutsNumber > 30000 || nutsNumber % 100 != 0)
            throw new IllegalArgumentException("Illegal number of nuts. Allowed values: from 100 to 30000, divisible by 100");
        if (nutsLostPercentage < 0 || nutsLostPercentage > 100)
            throw new IllegalArgumentException("Illegal percentage of lost nuts. Allowed values: from 0 to 100");
        if (nutsPrice < 1 || nutsPrice > 100)
            throw new IllegalArgumentException("Illegal price of nuts. Allowed values: from 1 to 100");
        this.nutsNumber = nutsNumber;
        this.nutsLostPercentage = nutsLostPercentage;
        this.nutsPrice = nutsPrice;
    }

    /**
     * Sets information about bolts in the warehouse.
     *
     * @param boltsNumber         number of bolts were in warehouse before loss. Allowed values: from 100 to 30000, divisible by 100.
     * @param boltsLostPercentage percentage of bolts were lost.Allowed values: from 0 to 100.
     * @param boltsPrice          price of one bolt. Allowed values: from 1 to 100.
     */
    public void setBoltsData(int boltsNumber, int boltsLostPercentage, int boltsPrice) {
        if (boltsNumber < 100 || boltsNumber > 30000 || boltsNumber % 100 != 0)
            throw new IllegalArgumentException("Illegal number of bolts. Allowed values: from 100 to 30000, divisible by 100");
        if (boltsLostPercentage < 0 || boltsLostPercentage > 100)
            throw new IllegalArgumentException("Illegal percentage of lost bolts. Allowed values: from 0 to 100");
        if (boltsPrice < 1 || boltsPrice > 100)
            throw new IllegalArgumentException("Illegal price of bolts. Allowed values: from 1 to 100");
        this.boltsNumber = boltsNumber;
        this.boltsLostPercentage = boltsLostPercentage;
        this.boltsPrice = boltsPrice;
    }
}
