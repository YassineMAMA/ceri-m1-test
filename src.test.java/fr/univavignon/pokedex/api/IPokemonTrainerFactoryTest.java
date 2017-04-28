package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.ArrayList;
import java.util.List;

public class IPokemonTrainerFactoryTest {

	@Mock private IPokedexFactory PokedexFactory;
	@Mock private IPokemonMetadataProvider MetadataProvider;
	@Mock private IPokemonFactory pokemonFactory;
	@Mock private IPokedex pokedex;
	@Mock private static IPokemonTrainerFactory trainerFactory;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	List<Pokemon> pokemonS = new ArrayList<Pokemon>();
	
	@Before
	public void setUp() throws PokedexException {
		
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		
	}
	@Test 
	public void testCreateTrainer() throws PokedexException {
		
		assertEquals(0, pokedex.size());
		assertEquals(0, pokedex.addPokemon(pokemon));
		assertEquals(pokemon, pokedex.getPokemon(0));
		assertEquals(1, pokedex.getPokemons().size());
		
	}

}
