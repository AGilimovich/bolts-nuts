package com.gp;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class designed for writing output data into file.
 */
public class OutputWriter {
    /**
     * Writes data into specified file.
     *
     * @param file path to file to which data is written.
     * @param text data need to be written into file.
     */
    public static void write(String file, String text) {
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
