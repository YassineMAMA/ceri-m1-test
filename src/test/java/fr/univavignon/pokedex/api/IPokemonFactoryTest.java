package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
public class IPokemonFactoryTest {
	
	Pokemon pokemonBulbizarre;
	Pokemon pokemonAquali;
	
	@Mock private IPokemonFactory IPokemonFactoryMock;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
    public void setUp() throws PokedexException  {
		
		pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
	
		when(IPokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemonBulbizarre);
		when(IPokemonFactoryMock.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemonAquali);
    }

	@Test
	public void testGetBulbizarre()  {
		Pokemon bul = IPokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4);
		
		assertEquals(pokemonBulbizarre.getAttack(), bul.getAttack());
		assertEquals(pokemonBulbizarre.getDefense(), bul.getDefense());
		assertEquals(pokemonBulbizarre.getIndex(), bul.getIndex());
		assertEquals(pokemonBulbizarre.getName(), bul.getName());
		assertEquals(pokemonBulbizarre.getStamina(), bul.getStamina());
		assertEquals(pokemonBulbizarre.getIv(), bul.getIv(), 0.001);
		assertEquals(pokemonBulbizarre.getCandy(), bul.getCandy());
		assertEquals(pokemonBulbizarre.getCp(), bul.getCp());
		assertEquals(pokemonBulbizarre.getDust(), bul.getDust());
		assertEquals(pokemonBulbizarre.getHp(), bul.getHp());

	
	}
	
	@Test
	public void testGetAquali() {
		Pokemon aqu = IPokemonFactoryMock.createPokemon(133, 2729, 202, 5000, 4);
		
		assertEquals(pokemonAquali.getAttack(), aqu.getAttack());
		assertEquals(pokemonAquali.getDefense(), aqu.getDefense());
		assertEquals(pokemonAquali.getIndex(), aqu.getIndex());
		assertEquals(pokemonAquali.getName(), aqu.getName());
		assertEquals(pokemonAquali.getStamina(), aqu.getStamina());
		assertEquals(pokemonAquali.getIv(), aqu.getIv(), 0.001);
		assertEquals(pokemonAquali.getCandy(), aqu.getCandy());
		assertEquals(pokemonAquali.getCp(), aqu.getCp());
		assertEquals(pokemonAquali.getDust(), aqu.getDust());
		assertEquals(pokemonAquali.getHp(), aqu.getHp());
	}

}
