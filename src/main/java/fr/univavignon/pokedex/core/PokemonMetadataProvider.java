package fr.univavignon.pokedex.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

/**
 * 
 * @author adrie
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMetadataProvider.class);
	
	/**
	 * Instance unique non préinitialisée
	 */
	private static PokemonMetadataProvider INSTANCE = null;
	
	
	/**
	 * Constructeur privé
	 */
	private PokemonMetadataProvider(){
		this.getJson();
		
	}
 
	/**
	 * 
	 */
	private void getJson() {
		
		
		/*String url = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
        String genreJson;
		try (final InputStream in =  new URL(url).openConnection().getInputStream()) {
			genreJson = 
			
		        JSONArray genreArray = new JSONArray(genreJson);
		        // get the first genr
		        JSONObject firstGenre = (JSONObject) genreArray.get(0);
		        System.out.println(genreArray.get(0));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
       
		
		LOGGER.debug("WWWWWWWWWAZAZAZZ");
	
		
	}

	
 
	/** 
	 * Point d'accès pour l'instance unique du singleton 
	 */
	public static synchronized PokemonMetadataProvider getInstance() {			
		if (INSTANCE == null) { 	
			INSTANCE = new PokemonMetadataProvider();	
		}
		return INSTANCE;
	}


	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}

}
