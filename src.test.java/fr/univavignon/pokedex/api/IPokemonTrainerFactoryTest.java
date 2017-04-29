package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.ArrayList;
import java.util.List;

public class IPokemonTrainerFactoryTest {
	



	@Mock private IPokedexFactory pokedexFactory;
	@Mock private IPokedex pokedex;
	@Mock private IPokemonTrainerFactory pokemonTrainerFactory;
	@Mock public MockitoRule mockitoRule = MockitoJUnit.rule();

	
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonTrainerFactory.createTrainer("Nasreddine", Team.MYSTIC,  pokedexFactory)).thenReturn(pokemoTrainer);
	}
	@Test 
	public void testCreateTrainer() throws PokedexException {
		
		assertEquals(0, pokedex.size());
		assertEquals(0, pokedex.addPokemon(pokemon));
		assertEquals(pokemon, pokedex.getPokemon(0));
		assertEquals(1, pokedex.getPokemons().size());
		
	}

}
