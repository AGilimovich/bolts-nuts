package com.gp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class builds the warehouse representation.
 */
public class WarehouseBuilder {
    private static final String inputDataRegex = "(\\d+)\\s(\\d+)\\s(\\d+)";
    private static Pattern inputDataPattern = Pattern.compile(inputDataRegex);


    /**
     * Builds warehouse object and sets data about nuts and bolts in it.
     *
     * @param boltsData data about bolts in warehouse
     * @param nutsData
     * @return warehouse object with all data set.
     * @throws IllegalArgumentException if input data was not provided or if it has wrong format.
     */


    public static Warehouse build(String boltsData, String nutsData) {
        if (boltsData == null || nutsData == null)
            throw new IllegalArgumentException("No input data or not full data provided");
        Warehouse warehouse = null;
        Matcher boltsMatcher = inputDataPattern.matcher(boltsData);
        Matcher nutsMatcher = inputDataPattern.matcher(nutsData);

        if (boltsMatcher.matches() && nutsMatcher.matches()) {
            warehouse = new Warehouse();
            warehouse.setBoltsData(Integer.valueOf(boltsMatcher.group(1)), Integer.valueOf(boltsMatcher.group(2)), Integer.valueOf(boltsMatcher.group(3)));
            warehouse.setNutsData(Integer.valueOf(nutsMatcher.group(1)), Integer.valueOf(nutsMatcher.group(2)), Integer.valueOf(nutsMatcher.group(3)));
            return warehouse;
        } else
            throw new IllegalArgumentException("Input data are not matching pattern");

    }


}
