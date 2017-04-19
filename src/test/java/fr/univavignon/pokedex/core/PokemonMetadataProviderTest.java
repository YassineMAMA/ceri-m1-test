package fr.univavignon.pokedex.core;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest  {
	
	
	@Before
    public void setUp() throws PokedexException  {

		//create pokemon metadata provider
		this.setiPokemonMetadataProvider(PokemonMetadataProvider.getInstance());
		
		//create 2 pokemons
		this.setPokemonMetadataBulbizarre( new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
		this.setPokemonMetadataAquali( new PokemonMetadata(134, "Vaporeon", 186, 168, 260));
    }
	
}
