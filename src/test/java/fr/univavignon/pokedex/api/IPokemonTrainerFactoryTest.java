package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonTrainerFactoryTest {
	
	private PokemonTrainer pokemonTrainerVALOR;
	private PokemonTrainer pokemonTrainerMYSTIC;
	private PokemonTrainer pokemonTrainerINSTINCT;
	
	@Mock private IPokedexFactory iPokedexFactory;
	@Mock private IPokemonTrainerFactory iPokemonTrainerFactory;
	@Mock private IPokedex iPokedexTest;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	/**
	 * setup
	 * @throws PokedexException
	 */
	@Before
    public void setUp() throws PokedexException  {
		MockitoAnnotations.initMocks(this);
		
		//create trainer VALOR
		pokemonTrainerVALOR = new PokemonTrainer("Stys", Team.VALOR, iPokedexTest);
		when(iPokemonTrainerFactory.createTrainer("Stys", Team.VALOR, iPokedexFactory)).thenReturn(pokemonTrainerVALOR);
		
		//create trainer MYSTIC
		pokemonTrainerMYSTIC = new PokemonTrainer("Enemy1", Team.MYSTIC, iPokedexTest);
		when(iPokemonTrainerFactory.createTrainer("Enemy1", Team.MYSTIC, iPokedexFactory)).thenReturn(pokemonTrainerMYSTIC);
		
		//create trainer INSTINCT
		pokemonTrainerINSTINCT = new PokemonTrainer("Patricia", Team.INSTINCT, iPokedexTest);
		when(iPokemonTrainerFactory.createTrainer("Patricia", Team.INSTINCT, iPokedexFactory)).thenReturn(pokemonTrainerINSTINCT);
    }

	@Test
	public void testCreateTrainer() {
		//test for VALOR trainer
		PokemonTrainer pokTrainerVALOR = iPokemonTrainerFactory.createTrainer("Stys", Team.VALOR, iPokedexFactory);
		assertEquals(pokemonTrainerVALOR.getName(), pokTrainerVALOR.getName());
		assertEquals(pokemonTrainerVALOR.getPokedex().getPokemons().size(), pokTrainerVALOR.getPokedex().getPokemons().size());
		assertEquals(pokemonTrainerVALOR.getTeam(), pokTrainerVALOR.getTeam());
		
		//test for MYSTIC trainer
		PokemonTrainer pokTrainerMYSTIC = iPokemonTrainerFactory.createTrainer("Enemy1", Team.MYSTIC, iPokedexFactory);
		assertEquals(pokemonTrainerMYSTIC.getName(), pokTrainerMYSTIC.getName());
		assertEquals(pokemonTrainerMYSTIC.getPokedex().getPokemons().size(), pokTrainerMYSTIC.getPokedex().getPokemons().size());
		assertEquals(pokemonTrainerMYSTIC.getTeam(), pokTrainerMYSTIC.getTeam());
		
		//test for INSTINCT trainer
		PokemonTrainer pokTrainerINSTINCT = iPokemonTrainerFactory.createTrainer("Patricia", Team.INSTINCT, iPokedexFactory);
		assertEquals(pokemonTrainerINSTINCT.getName(), pokTrainerINSTINCT.getName());
		assertEquals(pokemonTrainerINSTINCT.getPokedex().getPokemons().size(), pokTrainerINSTINCT.getPokedex().getPokemons().size());
		assertEquals(pokemonTrainerINSTINCT.getTeam(), pokTrainerINSTINCT.getTeam());
	}
}
