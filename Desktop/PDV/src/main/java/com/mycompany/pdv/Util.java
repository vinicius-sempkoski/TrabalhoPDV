package com.mycompany.pdv;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author vsemp
 */
public class Util {

    public static String converteJsonString(
            BufferedReader bufferReader) throws IOException {

        String resposta = "";
        String jsonString = "";

        while ((resposta = bufferReader.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }
}
