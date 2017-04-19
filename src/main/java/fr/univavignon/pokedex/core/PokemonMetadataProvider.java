package fr.univavignon.pokedex.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
	
	
	private static List<PokemonMetadata> cacheListPokemonMetadata;
	

	/**
	 * Constructeur privé
	 */
	private PokemonMetadataProvider() {
		this.cacheListPokemonMetadata = new ArrayList<>(256);
		this.getJson();
	}

	/**
	 * 
	 */

	private void getJson() {

		String url = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
		String genreJson;
		try (final InputStream in = new URL(url).openConnection().getInputStream()) {
			genreJson = IOUtils.toString(in, "UTF-8");

			JSONArray genreArray = new JSONArray(genreJson);
			
			for (Object object : genreArray) {
				 JSONObject pok =  (JSONObject)object;
				 this.cacheListPokemonMetadata.add(new PokemonMetadata(pok.getInt("PkMn"), pok.getString("Identifier"), pok.getInt("BaseAttack"), pok.getInt("BaseDefense"), pok.getInt("BaseStamina")));		 														
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.debug("wwwAZAZAZZ");

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
		if(index < 0 || index > this.cacheListPokemonMetadata.size()){
			throw new PokedexException("l'index "+ index +" ne corresponds à aucun pokemon");	
		}else{
			return this.cacheListPokemonMetadata.get(index);
		}
		
	}

}
