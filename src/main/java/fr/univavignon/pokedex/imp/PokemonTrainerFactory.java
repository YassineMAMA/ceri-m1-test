package fr.univavignon.pokedex.imp;

import java.io.*;

import com.google.gson.Gson;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactory implements IPokemonTrainerFactory, Serializer {

	private String path;

    public PokemonTrainerFactory() {
        this.path = ".pokedex133/data/trainers/";
        this.initPath(path);
    }
   
    
    
/*--------------creation du trainer by name, team adn pokedexFactory--------------------*/

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokedex pokedex = (Pokedex) pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        PokemonTrainer pokemonTrainer = null;

        try {

            if (checkFile(path, name)) {
                System.out.println("chargement " + name );
                pokemonTrainer = (PokemonTrainer) this.loadData(name);
                System.out.println("chargement réussi");
            } else {
                System.out.println("sauvgarde " + name );
                pokemonTrainer = new PokemonTrainer(name, team, pokedex);
                this.saveData(pokemonTrainer);
            }

        } catch (Exception e) {
            e.getMessage();
        }

        return pokemonTrainer;
    }
    
    
    
/*--------------creation du trainer by name--------------------*/
 
    public PokemonTrainer createTrainer(String name) {

        PokemonTrainer pokemonTrainer = null;

        try {
            if (checkFile(path, name)) {
                System.out.println("Chargement " + name );
                pokemonTrainer = (PokemonTrainer) this.loadData(name);
                System.out.println("chargement réussi");
            } 
        } catch (Exception e) {
            e.getMessage();
        }
        
        return pokemonTrainer;
    }
    
    
/*--------------chargement--------------------*/
	@Override
    public Object loadData(String name) throws FileNotFoundException, PokedexException {

        if (path == null) {
            throw new PokedexException("undefined path");
        }
        
        PokemonTrainer pokemonTrainer = null;
        String filename = this.getFileName(path, name);

        try (Reader reader = new FileReader(filename)) {
        	
            Gson gson = new Gson();            
            pokemonTrainer = gson.fromJson(reader, PokemonTrainer.class);

            if (pokemonTrainer == null) {
                throw new PokedexException("erreur de chargement ");
             }
             reader.close();
        } 
        catch (IOException e) {
        	e.getMessage();
        }
        
       return pokemonTrainer;
	}
	
/*--------------sauvgarde--------------------*/
 
    @Override
    public void saveData(Object object) throws IOException, PokedexException {

        PokemonTrainer pokemonTrainer = (PokemonTrainer) object;
        
        if (pokemonTrainer == null || path == null) {
            throw new PokedexException("empty trainer or undefined path");
        }
        
        String filename = this.getFileName(path, pokemonTrainer.getName());
        this.persistData(filename, pokemonTrainer);
    }
    


}
