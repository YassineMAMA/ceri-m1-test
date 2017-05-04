package fr.univavignon.pokedex.imp;

import java.io.IOException;

public class CalculateIV {
	
	public static  double calculateIV(String name, int cp, int hp, int dust, boolean levelUp) {

        double iv = 0;

        String ivapi = "http://hoomies.fr/pokeiv/?";
        String params = "name=" + name
                + "&cp=" + cp
                + "&hp=" + hp
                + "&dust=" + dust
                + "&levelUp=" + levelUp;

        String link = ivapi + params;
        
        try {
            iv = Double.parseDouble(Check.check(link));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return iv;
    }

}
