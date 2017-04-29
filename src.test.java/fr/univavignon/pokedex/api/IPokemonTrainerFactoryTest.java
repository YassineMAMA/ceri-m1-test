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
	

	@Mock private IPokedexFactory PokedexFactory;
	@Mock private IPokedex pokedex;
	@Mock private IPokemonTrainerFactory pokemonTrainerFactory;
	@Mock public MockitoRule mockitoRule = MockitoJUnit.rule();

	

	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonTrainerFactory.createTrainer("uTG", Team.MYSTIC, PokedexFactory)).thenReturn(new PokemonTrainer("uTG",Team.MYSTIC,pokedex));;
	}
	@Test 
	public void testCreateTrainer() throws PokedexException {
		PokemonTrainer uTG = pokemonTrainerFactory.createTrainer("uTG", Team.MYSTIC, PokedexFactory);
		assertNotNull(uTG);
		assertEquals(uTG.getName(),"uTG");
		assertEquals(uTG.getTeam(),Team.MYSTIC);
		
	}

}
