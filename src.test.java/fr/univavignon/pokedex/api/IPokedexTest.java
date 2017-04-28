package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;


import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokedexTest {
	@Mock private IPokedex pokedex;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	PokemonMetadata PokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
	List<Pokemon> pokemonS = new ArrayList<Pokemon>();
	
	@Before
	public void setUp() throws PokedexException {
		pokemonS.add(pokemon);
		Mockito.when(pokedex.size()).thenReturn(0);
		Mockito.when(pokedex.addPokemon(pokemon)).thenReturn(0);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(pokemon);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemonS);
		Mockito.when(pokedex.getPokemon(-1)).thenThrow(new PokedexException(""));
	}
	
	@Test(expected=PokedexException.class)
	public void testPokemonException() throws PokedexException{
		pokedex.getPokemon(-1);
	}
	
	@Test 
	public void testPokedex() throws PokedexException{
		
		assertEquals(0, pokedex.size());
		assertEquals(0, pokedex.addPokemon(pokemon));
		assertEquals(pokemon, pokedex.getPokemon(0));
		assertEquals(1, pokedex.getPokemons().size());
		
	}
}
