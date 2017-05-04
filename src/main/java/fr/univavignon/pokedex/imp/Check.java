package fr.univavignon.pokedex.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Check {

    public static String check(String link) throws IOException {

        URL url = new URL(link);
        String content = "";
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null; ) {
                content += line;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return content;
    }


}