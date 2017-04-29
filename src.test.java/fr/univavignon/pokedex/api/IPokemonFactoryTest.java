package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonFactoryTest {
	
	@Mock private IPokemonFactory pokemonFactory;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Before
	public void setUp() throws PokedexException {
		
		int index = 0;
		int cp = 613;
		int hp = 64;
		int dust = 4000;
		int candy = 4;
		
		MockitoAnnotations.initMocks(this);		
		Mockito.when(pokemonFactory.createPokemon(index, cp, hp, dust, candy))
		.thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));	
		
		}
	
	
	
	@Test 
	public void testPokemonMetadata() throws PokedexException{
		
		Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		
		assertEquals(0,pokemon.getIndex());
		assertEquals("Bulbizarre",pokemon.getName());
		assertEquals(126,pokemon.getAttack());
		assertEquals(126,pokemon.getDefense());
		assertEquals(90,pokemon.getStamina());
		assertEquals(613, pokemon.getCp());
		assertEquals(64, pokemon.getHp());
		assertEquals(4000, pokemon.getDust());
		assertEquals(4, pokemon.getCandy());
		assertEquals(56, pokemon.getIv(),0);
	}
}
