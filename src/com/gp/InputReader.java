package com.gp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for reading input data from file.
 */
public class InputReader {

    /**
     * Reads line with specified number from file.
     *
     * @param file       path to file from which need to read line.
     * @param lineNumber number of line need to read.
     * @return line was read.
     * @throws FileNotFoundException    if file was not found on specified path.
     * @throws IllegalArgumentException if path to file was not provided or number of line less than 0.
     */
    public static String readLine(String file, int lineNumber) throws FileNotFoundException {
        if (file == null || lineNumber < 0) {
            throw new IllegalArgumentException();
        }
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int counter = 0;
            while (counter++ <= lineNumber && (line = reader.readLine()) != null) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}
