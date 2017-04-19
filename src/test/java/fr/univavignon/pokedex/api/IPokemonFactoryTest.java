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

public class IPokemonFactoryTest {
	
	private Pokemon pokemonBulbizarre;
	private Pokemon pokemonAquali;
	
	@Mock private IPokemonFactory iPokemonFactory;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	/**
	 * setUp
	 * @throws PokedexException
	 */
	@Before
    public void setUp() throws PokedexException  {
		MockitoAnnotations.initMocks(this);
		
		//create 2 pokemons
		pokemonBulbizarre = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonAquali = new Pokemon(133, "Vaporeon", 186, 168, 260, 1984, 172, 3500, 4, 69);
	
	
		//create return
		when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemonBulbizarre);
		when(iPokemonFactory.createPokemon(133, 1984, 172, 3500, 4)).thenReturn(pokemonAquali);
    }

	@Test
	public void testGetBulbizarre()  {
		Pokemon bul = iPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		
		
		assertEquals(126, bul.getAttack());
		assertEquals(126, bul.getDefense());
		assertEquals(0, bul.getIndex());
		assertEquals("Bulbasaur", bul.getName());
		assertEquals(90, bul.getStamina());
		assertEquals(56, bul.getIv(), 0.001);
		assertEquals(4, bul.getCandy());
		assertEquals(613, bul.getCp());
		assertEquals(4000, bul.getDust());
		assertEquals(64, bul.getHp());
	}
	
	
	@Test
	public void testGetAquali() {
		Pokemon aqu = iPokemonFactory.createPokemon(133, 1984, 172, 3500, 4);
		
		assertEquals(186, aqu.getAttack());
		assertEquals(168, aqu.getDefense());
		assertEquals(133, aqu.getIndex());
		assertEquals("Vaporeon", aqu.getName());
		assertEquals(260, aqu.getStamina());
		assertEquals(69, aqu.getIv(), 0.001);
		assertEquals(4, aqu.getCandy());
		assertEquals(1984, aqu.getCp());
		assertEquals(3500, aqu.getDust());
		assertEquals(172, aqu.getHp());
	}

	
	/**
	 * 
	 * @return
	 */
	public Pokemon getPokemonBulbizarre() {
		return pokemonBulbizarre;
	}

	/**
	 * 
	 * @param pokemonBulbizarre
	 */
	public void setPokemonBulbizarre(Pokemon pokemonBulbizarre) {
		this.pokemonBulbizarre = pokemonBulbizarre;
	}

	/**
	 * 
	 * @return
	 */
	public Pokemon getPokemonAquali() {
		return pokemonAquali;
	}

	/**
	 * 
	 * @param pokemonAquali
	 */
	public void setPokemonAquali(Pokemon pokemonAquali) {
		this.pokemonAquali = pokemonAquali;
	}

	/**
	 * 
	 * @return
	 */
	public IPokemonFactory getiPokemonFactory() {
		return iPokemonFactory;
	}

	/**
	 * 
	 * @param iPokemonFactory
	 */
	public void setiPokemonFactory(IPokemonFactory iPokemonFactory) {
		this.iPokemonFactory = iPokemonFactory;
	}
}
