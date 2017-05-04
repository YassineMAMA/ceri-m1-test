package fr.univavignon.pokedex.imp;


import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;
import fr.univavignon.pokedex.imp.Serializer;

import com.google.gson.Gson;
import java.io.*;

public class PokemonMetadataProvider implements IPokemonMetadataProvider, Serializer{

    private String API = "http://hoomies.fr/pokemeta/?id=";
    private String path;
    
    
    
    public PokemonMetadataProvider() {
        this.path = ".pokedex133/data/pokemons/";
        this.initPath(path);
    }
    
    
    
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    	
        String link = API + index;
        PokemonMetadata metadata = null;
    	

        if (index <= 0 || index > 150) {
            throw new PokedexException("invalid Id");
        }

        try {
            if (checkFile(path, Integer.toString(index))) {
                metadata = (PokemonMetadata) this.loadData(Integer.toString(index));
            } else {
                String content = Check.check(link);
                metadata = this.json2PokemonMetadata(content);
                this.saveData(metadata);
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return metadata;
    }

       
/*--- creation de PokemonMetadata depuis Json */
    private PokemonMetadata json2PokemonMetadata(String content) {

        Gson g = new Gson();

        PokemonMetadata pokemonMetadata = g.fromJson(content, PokemonMetadata.class);
        return pokemonMetadata;
    }
    
    
    
/*--------------chargement--------------------*/
    @Override
    public Object loadData(String name) throws FileNotFoundException, PokedexException {

        if (path == null) {
            throw new PokedexException(" undefined Metadata path");
        }

        PokemonMetadata pokemonMetadata = null;
        String filename = this.getFileName(path, name);

        try (Reader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            pokemonMetadata = gson.fromJson(reader, PokemonMetadata.class);
            
            if (pokemonMetadata == null) {
                throw new PokedexException(" loading Error");
            }
            
            reader.close();
        } 
        catch (IOException e) {
            e.getMessage();
        }
        
        return pokemonMetadata;
    }
    
    
    
/*--------------sauvgarde--------------------*/
    @Override
    public void saveData(Object object) throws IOException, PokedexException {

        PokemonMetadata pokemonMetadata = (PokemonMetadata) object;

        if (pokemonMetadata == null || path == null) {
            throw new PokedexException("empty metadata or undefined path");
        }
        
        String filename = this.getFileName(path, Integer.toString(pokemonMetadata.getIndex()));
        this.persistData(filename, pokemonMetadata);
    }


}
