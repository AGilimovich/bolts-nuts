package com.gp;

public class Main {

    public static void main(String[] args) {
        final String inputFile = "resources/INPUT.TXT";
        final String outputFile = "resources/OUTPUT.TXT";
        try {
            String boltsData = InputReader.readLine(inputFile, 0);
            String nutsData = InputReader.readLine(inputFile, 1);
            Warehouse warehouse = WarehouseBuilder.build(boltsData, nutsData);
            OutputWriter.write(outputFile, String.valueOf(warehouse.countLosses()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
