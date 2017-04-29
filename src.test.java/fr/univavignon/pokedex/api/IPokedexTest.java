package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexTest {
	@Mock private IPokedex pokedex;
	
	private int index = 0;
	private List<Pokemon> pokemonList = new ArrayList<Pokemon>(151);
	private Pokemon aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
	private Pokemon bulbizzare = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);

	@Before 
	public void setUp() throws PokedexException{
		
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(pokedex.addPokemon(aquali)).thenReturn(index++);
		pokemonList.add(aquali);
		Mockito.when(pokedex.getPokemon(0)).thenReturn(aquali);
		
		Mockito.when(pokedex.addPokemon(bulbizzare)).thenReturn(index++);
		pokemonList.add(bulbizzare);
		Mockito.when(pokedex.getPokemon(1)).thenReturn(bulbizzare);
		
		Mockito.when(pokedex.size()).thenReturn(index);
		Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);
	}
	
	
	@Test(expected=PokedexException.class)
	public void testPokemonException() throws PokedexException{
		pokedex.getPokemon(-1);
	}
	
	@Test 
	public void testPokedex() throws PokedexException{
		List<Pokemon> pokemons = pokedex.getPokemons();
		
		assertEquals(pokedex.addPokemon(aquali), 0);
		assertEquals(pokedex.size(), 1);
		assertEquals(pokedex.addPokemon(bulbizzare), 1);
		assertEquals(pokedex.size(), 2);
		
		assertEquals(pokedex.getPokemon(0), aquali);
		assertEquals(pokedex.getPokemon(1), bulbizzare);
				
		assertEquals(pokemonList, pokemons);		
	}
	
	
}
